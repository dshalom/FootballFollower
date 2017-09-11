package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.Competitions.CompetitionsViewModel
import com.davidshalom.footballfollower.di.modules.*
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
        LoggerModule::class,
        RepositoryModule::class,
        DbModule::class
))

interface AppComponent {
    fun plus(leagueSelectionModule: LeagueSelectionModule): LeagueSelectionComponent

    fun inject(competitionsViewModel: CompetitionsViewModel)

    interface Injectable {
        fun inject(appComponent: AppComponent)
    }
}