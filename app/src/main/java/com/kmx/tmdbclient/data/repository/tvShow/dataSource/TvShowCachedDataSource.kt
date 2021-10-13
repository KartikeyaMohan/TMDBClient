package com.kmx.tmdbclient.data.repository.tvShow.dataSource

import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow

interface TvShowCachedDataSource {

    suspend fun getTvShowsFromCache(): List<TVShow>
    suspend fun saveTvShowsToCache(tvShow: List<TVShow>)
}