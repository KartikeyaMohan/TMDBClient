package com.kmx.tmdbclient.data.repository.tvShow

import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowCachedDataSource
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.kmx.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
        private val tvShowRemoteDataSource: TvShowRemoteDataSource,
        private val tvShowLocalDataSource: TvShowLocalDataSource,
        private val tvShowCacheDataSource: TvShowCachedDataSource
    ): TvShowRepository {

    override suspend fun geTvShows(): List<TVShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        val newList = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newList)
        tvShowCacheDataSource.saveTvShowsToCache(newList)
        return newList
    }

    suspend fun getTvShowFromApi(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (null != body) {
                tvShowList = body.TVShows
            }
        }
        catch (exception: Exception) {

        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }
        catch (exception: Exception) {

        }
        if(tvShowList.size > 0) {
            return tvShowList
        }
        else {
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }
        catch (exception: Exception) {

        }
        if(tvShowList.size > 0) {
            return tvShowList
        }
        else {
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}