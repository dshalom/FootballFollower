package com.davidshalom.footballfollower.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.davidshalom.footballfollower.model.db.entities.AppDatabase
import com.davidshalom.footballfollower.model.db.entities.CompetitionDao
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