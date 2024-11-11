package com.ahmadabuhasan.brightonrealestate.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ahmadabuhasan.brightonrealestate.data.models.DetailModel
import com.ahmadabuhasan.brightonrealestate.data.repository.Result
import com.ahmadabuhasan.brightonrealestate.databinding.ActivityDetailMovieBinding
import com.ahmadabuhasan.brightonrealestate.viewmodel.MovieViewModel
import com.ahmadabuhasan.brightonrealestate.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import java.lang.Float.parseFloat

class DetailMovieActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModels {
        ViewModelFactory(
            applicationContext
        )
    }

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        val id = intent.getStringExtra("id").toString()
        getByID(id)
    }

    private fun getByID(id: String) {
        viewModel.getByID(id).observe(this@DetailMovieActivity) { result ->
            if (result != null) {
                when (result) {
                    is Result.Loading -> {
                        showLoading(true)
                    }

                    is Result.Success -> {
                        showLoading(false)

                        val responseBody = result.data
                        setUI(responseBody)
                    }

                    is Result.Error -> {
                        showLoading(false)
                    }
                }
            }
        }
    }

    private fun setUI(detail: DetailModel) {
        Glide.with(this)
            .load(detail.poster)
            .skipMemoryCache(true)
            .into(binding.ivMoviePoster)

        binding.collapsingMovie.title = detail.title
        binding.tvRuntime.text = detail.runtime
        binding.ratingBar.rating = parseFloat(detail.imdbRating.toString())
        binding.tvMovieDetailOverview.text = detail.plot
        binding.tvGenre.text = detail.genre
        binding.tvDirector.text = detail.director
        binding.tvActors.text = detail.actors
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}