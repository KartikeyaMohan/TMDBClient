package com.kmx.tmdbclient.data.repository.tvShow.dataSourceImpl

import com.kmx.tmdbclient.data.db.TvShowDao
import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TVShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShow: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTvShows()
        }
    }
}