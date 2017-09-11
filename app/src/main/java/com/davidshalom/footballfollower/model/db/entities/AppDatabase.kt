package com.davidshalom.footballfollower.model.db.entities

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Competition::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DB_NAME = "people_db"
        var dbInstance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDatabase>(context.applicationContext, AppDatabase::class.java, DB_NAME).build()
            }
            return dbInstance
        }
    }

    abstract fun competitionDao(): CompetitionDao
}