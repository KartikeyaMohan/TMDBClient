package com.kmx.tmdbclient.domain.usecase

import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow
import com.kmx.tmdbclient.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository)  {

    suspend fun execute(): List<TVShow>? = tvShowRepository.geTvShows()

}