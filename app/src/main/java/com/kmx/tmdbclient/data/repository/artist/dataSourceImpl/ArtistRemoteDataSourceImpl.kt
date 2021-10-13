package com.kmx.tmdbclient.data.repository.artist.dataSourceImpl

import com.kmx.tmdbclient.data.api.TMDBService
import com.kmx.tmdbclient.data.models.artistObjects.ArtistList
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
        private val tmdbService: TMDBService,
        private val apiKey: String
    ): ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}