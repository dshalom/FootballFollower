package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import android.content.Context
import com.davidshalom.footballfollower.db.entities.AppDatabase
import com.davidshalom.footballfollower.db.entities.Competition
import com.davidshalom.footballfollower.model.services.FootballService

class CompetitionsRepository(context: Context, val footballService: FootballService) {

    val context = context
    fun getCompetitions(): LiveData<List<Competition>> {
        //   val data = MutableLiveData<List<Competition>>()

        val db = Room.databaseBuilder(context,
                AppDatabase::class.java, "people_db").build()

        return db.competitionDao().all

        //      val call = footballService.getCompetitions()

//        call.enqueue(object : retrofit2.Callback<List<Competition>> {
//            override fun onResponse(call: Call<List<Competition>>?, response: Response<List<Competition>>) {
//                if (response.isSuccessful) {
//                    data.setValue(response.body())
//
//
//                    //             val db = Room.databaseBuilder(context,
//                    //                   AppDatabase::class.java, "people_db").build()
//
//                    //         val i =9
//
////
////                    val c = db.competitionDao()?.count()
//
//                    //    Log.e("dsds", ""+c)
//
//                } else {
//                    //   val res = ApiResponse<List<Competition>>()
//                    // res.error = NoSuchElementException()
//                    //  data.setValue(res)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Competition>>?, t: Throwable?) {
//                //    val res = ApiResponse<List<Competition>>()
//                //  res.error = t
//                // data.value = res
//            }
//        })
        return data
    }
}

