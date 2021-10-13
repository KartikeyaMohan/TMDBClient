package com.kmx.tmdbclient.domain.usecase

import com.kmx.tmdbclient.data.models.artistObjects.Artist
import com.kmx.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}