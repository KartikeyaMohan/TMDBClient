package com.kmx.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmx.tmdbclient.R
import com.kmx.tmdbclient.data.models.movieObjects.Movie
import com.kmx.tmdbclient.databinding.MovieListItemBinding

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MovieListItemBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.movie_list_item,
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList.get(position))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(val binding: MovieListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.title.text = movie.title
            binding.overview.text = movie.overview
            binding.releaseDate.text = movie.releaseDate
            val posterUrl = "https://image.tmdb.org/t/p/w500".plus(movie.posterPath)
            Glide.with(binding.poster.context).load(posterUrl).into(binding.poster)
        }
    }
}