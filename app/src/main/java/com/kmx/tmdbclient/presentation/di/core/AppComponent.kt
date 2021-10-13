package com.kmx.tmdbclient.presentation.di.core

import com.kmx.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.kmx.tmdbclient.presentation.di.movie.MovieSubComponent
import com.kmx.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    LocalDataModule::class,
    CachedDataModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}