package com.kmx.tmdbclient.data.repository.movie.dataSourceImpl

import com.kmx.tmdbclient.data.models.movieObjects.Movie
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieCachedDataSource

class MovieCachedDataSourceImpl: MovieCachedDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}