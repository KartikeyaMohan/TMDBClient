package com.kmx.tmdbclient.data.repository.movie.dataSource

import com.kmx.tmdbclient.data.models.movieObjects.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}