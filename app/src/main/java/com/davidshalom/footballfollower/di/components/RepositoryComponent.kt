package com.davidshalom.footballfollower.di.components

import com.davidshalom.footballfollower.Competitions.CompetitionsViewModel
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import com.davidshalom.footballfollower.di.modules.RepositoryModule
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {

    fun inject(competitionsViewModel: CompetitionsViewModel)

    interface Injectable {
        fun inject(countdownComponent: RepositoryComponent)
    }
}