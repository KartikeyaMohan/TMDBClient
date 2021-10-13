package com.kmx.tmdbclient.presentation.di.core

import com.kmx.tmdbclient.data.db.ArtistDao
import com.kmx.tmdbclient.data.db.MovieDao
import com.kmx.tmdbclient.data.db.TvShowDao
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.kmx.tmdbclient.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.kmx.tmdbclient.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.kmx.tmdbclient.data.repository.tvShow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}