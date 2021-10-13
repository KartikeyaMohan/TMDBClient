package com.kmx.tmdbclient.domain.repository

import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow

interface TvShowRepository {

    suspend fun geTvShows(): List<TVShow>?

    suspend fun updateTvShows(): List<TVShow>?
}