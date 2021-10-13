package com.kmx.tmdbclient.presentation.di.tvShow

import com.kmx.tmdbclient.domain.usecase.GetTvShowUseCase
import com.kmx.tmdbclient.domain.usecase.UpdateTvShowUseCase
import com.kmx.tmdbclient.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowUseCase,
            updateTvShowUseCase
        )
    }
}