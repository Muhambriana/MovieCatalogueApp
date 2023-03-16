package com.muhamapps.moviecatalogueapp3.ui.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muhamapps.moviecatalogueapp3.R
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.databinding.ItemsMovieBinding
import com.muhamapps.moviecatalogueapp3.ui.detail.DetailCatalogueActivity

class FavoriteMoviesAdapter : PagedListAdapter<MovieEntity, FavoriteMoviesAdapter.FavoriteMovieViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemsFavoriteMoviesBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(itemsFavoriteMoviesBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val movie = getItem(position)
        if(movie != null){
            holder.bind(movie)
        }
    }

inner class FavoriteMovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieEntity) {
        with(binding) {
            tvItemTitle.text = movie.title
            tvItemRate.text = movie.rate
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailCatalogueActivity::class.java)
                intent.putExtra(DetailCatalogueActivity.EXTRA_MOVIE, movie.movieId)
                itemView.context.startActivity(intent)
            }
            Glide.with(itemView.context)
                .load(movie.poster)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(imgPoster)
        }
    }
}
}