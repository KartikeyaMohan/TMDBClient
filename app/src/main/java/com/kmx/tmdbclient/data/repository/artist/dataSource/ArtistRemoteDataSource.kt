package com.kmx.tmdbclient.data.repository.artist.dataSource

import com.kmx.tmdbclient.data.models.artistObjects.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}