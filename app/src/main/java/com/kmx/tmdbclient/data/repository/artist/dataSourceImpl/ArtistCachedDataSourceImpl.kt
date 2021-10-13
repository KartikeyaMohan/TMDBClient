package com.kmx.tmdbclient.data.repository.artist.dataSourceImpl

import com.kmx.tmdbclient.data.models.artistObjects.Artist
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistCachedDataSource

class ArtistCachedDataSourceImpl: ArtistCachedDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}