package com.davidshalom.footballfollower.di.modules

import android.content.Context
import com.davidshalom.footballfollower.Competitions.CompetitionsRepository
import com.davidshalom.footballfollower.db.entities.AppDatabase
import com.davidshalom.footballfollower.db.entities.CompetitionDao
import com.davidshalom.footballfollower.di.scopes.LeagueSelectionScope
import com.davidshalom.footballfollower.model.services.FootballService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCompetitionsRepository(context: Context, footballService: FootballService, competitionsDao: CompetitionDao): CompetitionsRepository {
        return CompetitionsRepository(context, footballService, competitionsDao)
    }
}