package com.davidshalom.footballfollower.di.modules

import com.davidshalom.footballfollower.Spanner
import com.davidshalom.footballfollower.di.scopes.LeagueSelectionScope
import dagger.Module
import dagger.Provides

@Module
class LeagueSelectionModule {

    @Provides
    @LeagueSelectionScope
    fun provideSpanner(): Spanner {
        return Spanner()
    }

}