package com.kmx.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kmx.tmdbclient.domain.usecase.GetArtistUseCase
import com.kmx.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistsViewModel(
        private val getArtistUseCase: GetArtistUseCase,
        private val updateArtistUseCase: UpdateArtistUseCase
    ): ViewModel() {

    fun getArtists() = liveData {
        val movieList = getArtistUseCase.execute()
        emit(movieList)
    }

    fun updateArtists() = liveData {
        val movieList = updateArtistUseCase.execute()
        emit(movieList)
    }
}