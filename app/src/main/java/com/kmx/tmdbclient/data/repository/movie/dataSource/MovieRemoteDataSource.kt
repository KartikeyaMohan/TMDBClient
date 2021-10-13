package com.kmx.tmdbclient.data.repository.movie.dataSource

import com.kmx.tmdbclient.data.models.movieObjects.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}