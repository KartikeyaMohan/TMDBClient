package com.kmx.tmdbclient.domain.repository

import com.kmx.tmdbclient.data.models.artistObjects.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}