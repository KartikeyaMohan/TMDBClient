package com.kmx.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kmx.tmdbclient.data.models.tvShowObjects.TVShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow: List<TVShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShows(): List<TVShow>
}