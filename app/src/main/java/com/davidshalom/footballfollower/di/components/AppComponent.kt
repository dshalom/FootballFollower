package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.LeagueSelectionActivity
import com.davidshalom.footballfollower.di.modules.AppModule
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import dagger.Component
import xyz.ivankocijan.kotlinexample.dagger.setup.module.*
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppContextModule::class,
        RetrofitModule::class,
        ClientModule::class,
        GsonConverterModule::class,
        GsonModule::class,
        HostModule::class,
        LoggerModule::class
))

interface AppComponent {
    fun plus(leagueSelectionModule: LeagueSelectionModule): LeagueSelectionComponent
}
