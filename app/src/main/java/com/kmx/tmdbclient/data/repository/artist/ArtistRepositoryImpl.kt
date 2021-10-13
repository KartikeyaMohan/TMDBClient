package com.kmx.tmdbclient.data.repository.artist

import com.kmx.tmdbclient.data.models.artistObjects.Artist
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistCachedDataSource
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.kmx.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
        private val artistRemoteDataSource: ArtistRemoteDataSource,
        private val artistLocalDataSource: ArtistLocalDataSource,
        private val artistCacheDataSource: ArtistCachedDataSource
    ): ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newList = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newList)
        artistCacheDataSource.saveArtistsToCache(newList)
        return newList
    }

    suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (null != body) {
                artistList = body.artists
            }
        }
        catch (exception: Exception) {

        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        }
        catch (exception: Exception) {

        }
        if(artistList.size > 0) {
            return artistList
        }
        else {
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }
        catch (exception: Exception) {

        }
        if(artistList.size > 0) {
            return artistList
        }
        else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}