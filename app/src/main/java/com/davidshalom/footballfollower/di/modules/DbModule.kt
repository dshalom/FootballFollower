package com.davidshalom.footballfollower.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.davidshalom.footballfollower.db.entities.AppDatabase
import com.davidshalom.footballfollower.db.entities.CompetitionDao
import com.davidshalom.footballfollower.di.scopes.LeagueSelectionScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun providedDb(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "people_db").allowMainThreadQueries().build()


    @Provides
    @Singleton
    fun provideCompetitionDao(appDatabase: AppDatabase): CompetitionDao {
        return appDatabase.competitionDao()
    }

}