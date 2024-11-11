package com.ahmadabuhasan.brightonrealestate.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmadabuhasan.brightonrealestate.data.models.ListModel
import com.ahmadabuhasan.brightonrealestate.databinding.ItemMovieBinding
import com.bumptech.glide.Glide

class MainAdapter(
    private val listMovie: MutableList<ListModel>
) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(data: MutableList<ListModel>) {
        val diffCallback = DiffUtilCallback(listMovie, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listMovie.clear()
        listMovie.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(
                listMovie[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    class ListViewHolder(private val _binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(_binding.root) {
        fun bind(movie: ListModel) {
            _binding.tvTitle.text = movie.title
            _binding.tvYear.text = movie.year

            Glide.with(itemView.context)
                .load(movie.poster)
                .skipMemoryCache(true)
                .into(_binding.imgMovie)
        }
    }

    fun interface OnItemClickCallback {
        fun onItemClicked(data: ListModel)
    }

    class DiffUtilCallback(
        private val oldList: List<ListModel>,
        private val newList: List<ListModel>
    ) :
        DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return oldItem.javaClass == newItem.javaClass
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return oldItem.hashCode() == newItem.hashCode()
        }

        @Override
        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }
    }

}