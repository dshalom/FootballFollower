package com.davidshalom.footballfollower.di.modules

import com.davidshalom.footballfollower.LeagueSelectionActivity
import com.davidshalom.footballfollower.Spanner
import com.davidshalom.footballfollower.di.scopes.LeagueSelectionScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LeagueSelectionModule(val activity: LeagueSelectionActivity) {

    @Provides
    @LeagueSelectionScope
    fun provideLeagueSelectionActivity() = activity

    @Provides
    @LeagueSelectionScope
    fun provideSpanner(): Spanner {
        return Spanner();
    }

}