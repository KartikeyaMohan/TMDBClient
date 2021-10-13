package com.kmx.tmdbclient.domain.usecase

import com.kmx.tmdbclient.data.models.movieObjects.Movie
import com.kmx.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}