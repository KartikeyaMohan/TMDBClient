package com.kmx.tmdbclient.data.repository.movie.dataSourceImpl

import com.kmx.tmdbclient.data.api.TMDBService
import com.kmx.tmdbclient.data.models.movieObjects.MovieList
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String): MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}