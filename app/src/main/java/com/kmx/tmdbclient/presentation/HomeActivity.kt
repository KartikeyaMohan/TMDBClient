package com.kmx.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kmx.tmdbclient.R
import com.kmx.tmdbclient.databinding.ActivityHomeBinding
import com.kmx.tmdbclient.presentation.artists.ArtistsActivity
import com.kmx.tmdbclient.presentation.movie.MovieActivity
import com.kmx.tmdbclient.presentation.tvShow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        addListeners()
    }

    private fun addListeners() {
        binding.movies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.tvShows.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
        binding.artists.setOnClickListener {
            val intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }
    }
}