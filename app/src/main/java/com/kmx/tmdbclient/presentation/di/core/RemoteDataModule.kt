package com.kmx.tmdbclient.presentation.di.core

import com.kmx.tmdbclient.data.api.TMDBService
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.kmx.tmdbclient.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.kmx.tmdbclient.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.kmx.tmdbclient.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistsRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}