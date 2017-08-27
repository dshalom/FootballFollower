package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.LeagueSelectionActivity
import com.davidshalom.footballfollower.di.modules.AppModule
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun plus(leagueSelectionModule: LeagueSelectionModule): LeagueSelectionComponent
}
