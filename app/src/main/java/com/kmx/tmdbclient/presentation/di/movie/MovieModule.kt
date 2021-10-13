package com.kmx.tmdbclient.presentation.di.movie

import com.kmx.tmdbclient.domain.usecase.GetMoviesUseCase
import com.kmx.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.kmx.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}