package com.davidshalom.footballfollower.db.entities

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface CompetitionDao {
    @get:Query("SELECT * FROM competition")
    val all: LiveData<List<Competition>>

    @Query("SELECT COUNT(*) FROM competition")
    fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg competions: Competition)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll2(competions: List<Competition>?)

}