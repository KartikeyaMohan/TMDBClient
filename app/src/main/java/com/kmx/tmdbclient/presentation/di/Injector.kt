package com.kmx.tmdbclient.presentation.di

import com.kmx.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.kmx.tmdbclient.presentation.di.movie.MovieSubComponent
import com.kmx.tmdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}