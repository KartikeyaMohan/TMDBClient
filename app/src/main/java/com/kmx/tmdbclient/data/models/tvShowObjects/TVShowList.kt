package com.kmx.tmdbclient.data.models.tvShowObjects
import com.google.gson.annotations.SerializedName
import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow

data class TVShowList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)