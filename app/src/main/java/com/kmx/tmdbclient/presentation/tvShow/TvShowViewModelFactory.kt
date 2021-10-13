package com.kmx.tmdbclient.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kmx.tmdbclient.domain.usecase.GetTvShowUseCase
import com.kmx.tmdbclient.domain.usecase.UpdateTvShowUseCase
import com.kmx.tmdbclient.presentation.movie.MovieViewModel

class TvShowViewModelFactory(
        private val getTvShowUseCase: GetTvShowUseCase,
        private val updateTvShowUseCase: UpdateTvShowUseCase
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}