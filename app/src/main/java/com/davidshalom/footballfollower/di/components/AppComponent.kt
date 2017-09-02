package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.Competitions.CompetitionsViewModel
import com.davidshalom.footballfollower.di.modules.AppContextModule
import com.davidshalom.footballfollower.di.modules.RetrofitModule
import com.davidshalom.footballfollower.di.modules.ClientModule
import com.davidshalom.footballfollower.di.modules.CallAdapterModule
import com.davidshalom.footballfollower.di.modules.GsonConverterModule
import com.davidshalom.footballfollower.di.modules.GsonModule
import com.davidshalom.footballfollower.di.modules.LoggerModule
import com.davidshalom.footballfollower.di.modules.HostModule
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import dagger.Component
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

    fun inject(competitionsViewModel: CompetitionsViewModel)

    interface Injectable {
        fun inject(countdownComponent: AppComponent)
    }
}