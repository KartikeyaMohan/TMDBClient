package com.kmx.tmdbclient.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmx.tmdbclient.R
import com.kmx.tmdbclient.databinding.ActivityArtistsBinding
import com.kmx.tmdbclient.presentation.di.Injector
import com.kmx.tmdbclient.presentation.tvShow.TvShowAdapter
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var artistsViewModel: ArtistsViewModel
    private lateinit var binding: ActivityArtistsBinding
    private lateinit var adapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
        (application as Injector).createArtistSubComponent().inject(this)

        artistsViewModel = ViewModelProvider(this, factory).get(ArtistsViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistsRecycler.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistsRecycler.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = artistsViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if(null != it)
            {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
            binding.progressBar.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateTvShows() {
        binding.progressBar.visibility = View.VISIBLE
        val response = artistsViewModel.updateArtists()
        response.observe(this, Observer {
            if(null != it)
            {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
            binding.progressBar.visibility = View.GONE
        })
    }
}