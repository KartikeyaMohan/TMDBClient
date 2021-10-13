package com.kmx.tmdbclient.data.repository.movie.dataSource

import com.kmx.tmdbclient.data.models.movieObjects.Movie

interface MovieCachedDataSource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}