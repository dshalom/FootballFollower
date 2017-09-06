package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Room
import android.content.Context
import android.util.Log
import com.davidshalom.footballfollower.db.entities.AppDatabase
import com.davidshalom.footballfollower.db.entities.Competition
import com.davidshalom.footballfollower.model.services.FootballService
import retrofit2.Call
import retrofit2.Response

class CompetitionsRepository(context: Context, val footballService: FootballService) {

    val context = context
    val db = Room.databaseBuilder(context,
            AppDatabase::class.java, "people_db").allowMainThreadQueries().build()

    fun getCompetitions(): LiveData<List<Competition>> {
        val call = footballService.getCompetitions()
        call.enqueue(object : retrofit2.Callback<List<Competition>> {
            override fun onResponse(call: Call<List<Competition>>?, response: Response<List<Competition>>) {
                if (response.isSuccessful) {


                    db.competitionDao().insertAll2(response.body())

                } else {
                    //   val res = ApiResponse<List<Competition>>()
                    // res.error = NoSuchElementException()
                    //  data.setValue(res)
                }
            }

            override fun onFailure(call: Call<List<Competition>>?, t: Throwable?) {
                //    val res = ApiResponse<List<Competition>>()
                //  res.error = t
                // data.value = res
            }
        })

        return db.competitionDao().all
    }
}

