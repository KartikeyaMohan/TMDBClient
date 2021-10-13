package com.kmx.tmdbclient.domain.repository

import com.kmx.tmdbclient.data.models.movieObjects.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}