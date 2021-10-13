package com.kmx.tmdbclient.presentation.di.core

import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistCachedDataSource
import com.kmx.tmdbclient.data.repository.artist.dataSourceImpl.ArtistCachedDataSourceImpl
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieCachedDataSource
import com.kmx.tmdbclient.data.repository.movie.dataSourceImpl.MovieCachedDataSourceImpl
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowCachedDataSource
import com.kmx.tmdbclient.data.repository.tvShow.dataSourceImpl.TvShowCachedDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CachedDataModule {

    @Singleton
    @Provides
    fun provideMovieCachedDataSource(): MovieCachedDataSource {
        return MovieCachedDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCachedDataSource(): TvShowCachedDataSource {
        return TvShowCachedDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCachedDataSource(): ArtistCachedDataSource {
        return ArtistCachedDataSourceImpl()
    }
}