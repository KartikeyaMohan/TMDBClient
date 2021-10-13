package com.kmx.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kmx.tmdbclient.domain.usecase.GetArtistUseCase
import com.kmx.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.kmx.tmdbclient.presentation.movie.MovieViewModel

class ArtistsViewModelFactory(
        private val getArtistUseCase: GetArtistUseCase,
        private val updateArtistUseCase: UpdateArtistUseCase
    ): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getArtistUseCase, updateArtistUseCase) as T
    }
}