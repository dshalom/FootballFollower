package com.davidshalom.footballfollower.di.modules

import com.davidshalom.footballfollower.Competitions.CompetitionsRepository
import com.davidshalom.footballfollower.model.services.FootballService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCompetitionsRepository(footballService : FootballService): CompetitionsRepository {
        return CompetitionsRepository(footballService)
    }
}