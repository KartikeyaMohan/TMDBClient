package com.kmx.tmdbclient.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmx.tmdbclient.R
import com.kmx.tmdbclient.data.models.artistObjects.Artist
import com.kmx.tmdbclient.databinding.ArtistListItemBinding

class ArtistAdapter: RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ArtistListItemBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.artist_list_item,
                parent,
                false
            )
        return ArtistAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artistList.get(position))
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    class ViewHolder(val binding: ArtistListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist) {
            binding.title.text = artist.name
            binding.overview.text = artist.popularity.toString()
            val posterUrl = "https://image.tmdb.org/t/p/w500".plus(artist.profilePath)
            Glide.with(binding.poster.context).load(posterUrl).into(binding.poster)
        }
    }
}