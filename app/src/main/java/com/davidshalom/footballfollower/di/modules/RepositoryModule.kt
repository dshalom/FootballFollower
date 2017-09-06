package com.davidshalom.footballfollower.di.modules

import android.content.Context
import com.davidshalom.footballfollower.Competitions.CompetitionsRepository
import com.davidshalom.footballfollower.model.services.FootballService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCompetitionsRepository(context: Context, footballService: FootballService): CompetitionsRepository {
        return CompetitionsRepository(context, footballService)
    }
}