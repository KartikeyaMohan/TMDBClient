package com.kmx.tmdbclient.data.repository.tvShow.dataSourceImpl

import com.kmx.tmdbclient.data.api.TMDBService
import com.kmx.tmdbclient.data.models.tvShowObjects.TVShowList
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
        private val tmdbService: TMDBService,
        private val apiKey: String
    ): TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TVShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}