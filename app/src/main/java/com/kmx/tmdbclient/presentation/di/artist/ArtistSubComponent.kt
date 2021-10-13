package com.kmx.tmdbclient.presentation.di.artist

import com.kmx.tmdbclient.presentation.artists.ArtistsActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistsActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}