package com.davidshalom.footballfollower.di.modules

import com.davidshalom.footballfollower.Competitions.CompetitionsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideLogger(): CompetitionsRepository {
        return CompetitionsRepository()
    }

}