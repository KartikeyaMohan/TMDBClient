package com.kmx.tmdbclient.presentation.di.core

import com.kmx.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistCachedDataSource
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.kmx.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.kmx.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieCachedDataSource
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.kmx.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.kmx.tmdbclient.data.repository.tvShow.TvShowRepositoryImpl
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowCachedDataSource
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.kmx.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.kmx.tmdbclient.domain.repository.ArtistRepository
import com.kmx.tmdbclient.domain.repository.MovieRepository
import com.kmx.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCachedDataSource: MovieCachedDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCachedDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCachedDataSource: TvShowCachedDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCachedDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCachedDataSource: ArtistCachedDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCachedDataSource
        )
    }
}