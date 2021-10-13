package com.kmx.tmdbclient.data.repository.movie

import com.kmx.tmdbclient.data.models.movieObjects.Movie
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieCachedDataSource
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.kmx.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCachedDataSource
    ): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newList = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newList)
        movieCacheDataSource.saveMoviesToCache(newList)
        return newList
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (null != body) {
                movieList = body.movies
            }
        }
        catch (exception: Exception) {

        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }
        catch (exception: Exception) {

        }
        if(movieList.size > 0) {
            return movieList
        }
        else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }
        catch (exception: Exception) {

        }
        if(movieList.size > 0) {
            return movieList
        }
        else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}