package com.kmx.tmdbclient.data.repository.artist.dataSource

import com.kmx.tmdbclient.data.models.artistObjects.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}