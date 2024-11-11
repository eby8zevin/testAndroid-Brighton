package com.ahmadabuhasan.brightonrealestate.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadabuhasan.brightonrealestate.R
import com.ahmadabuhasan.brightonrealestate.data.models.ListModel
import com.ahmadabuhasan.brightonrealestate.data.repository.Result
import com.ahmadabuhasan.brightonrealestate.databinding.ActivityMainBinding
import com.ahmadabuhasan.brightonrealestate.viewmodel.MovieViewModel
import com.ahmadabuhasan.brightonrealestate.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModels {
        ViewModelFactory(
            applicationContext
        )
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSearch("avenger")
    }

    private fun getSearch(s: String) {
        viewModel.getSearch(s).observe(this@MainActivity) { result ->
            if (result != null) {
                when (result) {
                    is Result.Loading -> {
                        showLoading(true)
                    }

                    is Result.Success -> {
                        showLoading(false)
                        val responseBody = result.data
                        showRecyclerView(responseBody.search)
                    }

                    is Result.Error -> {
                        showLoading(false)
                        Toast.makeText(this, result.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun showRecyclerView(list: MutableList<ListModel>) {
        binding.rvMovie.layoutManager =
            if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                GridLayoutManager(this, 2)
            } else {
                LinearLayoutManager(this)
            }

        binding.rvMovie.setHasFixedSize(true)
        adapter = MainAdapter(list)
        binding.rvMovie.adapter = adapter

        adapter.setOnItemClickCallback { data -> selectedMovie(data) }
    }

    private fun selectedMovie(movie: ListModel) {
        Toast.makeText(this, "You choose ${movie.title}", Toast.LENGTH_SHORT).show()

        val i = Intent(this, DetailMovieActivity::class.java)
        i.putExtra("id", movie.imdbID)
        startActivity(i)
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        val close = menu.findItem(R.id.search)

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                getSearch(query)
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                getSearch(newText)
                return true
            }
        })
        close.icon?.setVisible(false, false)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite) {
            startActivity(Intent(this, FavoriteMovieActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}