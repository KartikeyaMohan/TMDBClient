package com.kmx.tmdbclient.data.repository.tvShow.dataSource

import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TVShow>
    suspend fun saveTvShowsToDB(tvShow: List<TVShow>)
    suspend fun clearAll()
}