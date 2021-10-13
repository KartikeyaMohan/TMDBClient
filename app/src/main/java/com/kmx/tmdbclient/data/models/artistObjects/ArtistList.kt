package com.kmx.tmdbclient.data.models.artistObjects
import com.google.gson.annotations.SerializedName
import com.kmx.tmdbclient.data.models.artistObjects.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)