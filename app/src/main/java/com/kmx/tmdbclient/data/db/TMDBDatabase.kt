package com.kmx.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kmx.tmdbclient.data.models.artistObjects.Artist
import com.kmx.tmdbclient.data.models.movieObjects.Movie
import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow

@Database(entities = [Movie::class, TVShow::class, Artist::class],
          version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvDao(): TvShowDao

    abstract fun artistDao(): ArtistDao
}