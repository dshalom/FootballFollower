package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.di.modules.*
import dagger.Component
import xyz.ivankocijan.kotlinexample.dagger.setup.module.HostModule
import com.davidshalom.footballfollower.di.modules.RetrofitModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppContextModule::class,
        RetrofitModule::class,
        ClientModule::class,
        CallAdapterModule::class,
        GsonConverterModule::class,
        GsonModule::class,
        HostModule::class,
        LoggerModule::class
))

interface AppComponent {
    fun plus(leagueSelectionModule: LeagueSelectionModule): LeagueSelectionComponent
}
