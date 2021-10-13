package com.kmx.tmdbclient.presentation.di.artist

import com.kmx.tmdbclient.domain.usecase.GetArtistUseCase
import com.kmx.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.kmx.tmdbclient.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }
}