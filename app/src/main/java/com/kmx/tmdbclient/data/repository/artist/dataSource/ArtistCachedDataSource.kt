package com.kmx.tmdbclient.data.repository.artist.dataSource

import com.kmx.tmdbclient.data.models.artistObjects.Artist

interface ArtistCachedDataSource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artist: List<Artist>)
}