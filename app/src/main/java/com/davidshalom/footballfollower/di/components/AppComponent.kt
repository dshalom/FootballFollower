package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.App
import com.davidshalom.footballfollower.LeagueSelectionActivity
import com.davidshalom.footballfollower.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
    fun inject(leagueSelectionActivity: LeagueSelectionActivity)

}
