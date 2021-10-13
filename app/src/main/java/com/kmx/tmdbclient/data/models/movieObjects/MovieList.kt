package com.kmx.tmdbclient.data.models.movieObjects
import com.google.gson.annotations.SerializedName
import com.kmx.tmdbclient.data.models.movieObjects.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)