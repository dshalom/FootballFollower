package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.LeagueSelectionActivity
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import com.davidshalom.footballfollower.di.scopes.LeagueSelectionScope
import dagger.Subcomponent
import javax.inject.Singleton

@LeagueSelectionScope
@Subcomponent(modules = arrayOf(LeagueSelectionModule::class))
interface LeagueSelectionComponent {
    fun inject(leagueSelectionActivity: LeagueSelectionActivity)
}