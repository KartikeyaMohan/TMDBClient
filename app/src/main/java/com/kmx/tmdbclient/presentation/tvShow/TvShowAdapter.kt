package com.kmx.tmdbclient.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmx.tmdbclient.R
import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow
import com.kmx.tmdbclient.databinding.TvShowListItemBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private val tvShowList = ArrayList<TVShow>()

    fun setList(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: TvShowListItemBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.tv_show_list_item,
                parent,
                false
            )
        return TvShowAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvShowList.get(position))
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    class ViewHolder(val binding: TvShowListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShow) {
            binding.title.text = tvShow.name
            binding.overview.text = tvShow.overview
            binding.releaseDate.text = tvShow.firstAirDate
            val posterUrl = "https://image.tmdb.org/t/p/w500".plus(tvShow.posterPath)
            Glide.with(binding.poster.context).load(posterUrl).into(binding.poster)
        }
    }
}