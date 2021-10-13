package com.kmx.tmdbclient.data.repository.tvShow.dataSource

import com.kmx.tmdbclient.data.models.tvShowObjects.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TVShowList>
}