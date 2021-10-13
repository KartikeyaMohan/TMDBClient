package com.kmx.tmdbclient.data.repository.tvShow.dataSourceImpl

import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowCachedDataSource

class TvShowCachedDataSourceImpl: TvShowCachedDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTvShowsFromCache(): List<TVShow> {
       return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShow: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}