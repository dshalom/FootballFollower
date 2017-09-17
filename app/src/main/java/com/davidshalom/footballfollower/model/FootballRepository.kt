package com.davidshalom.footballfollower.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.davidshalom.footballfollower.model.db.entities.Competition
import com.davidshalom.footballfollower.model.db.entities.CompetitionDao
import com.davidshalom.footballfollower.model.services.FootballService
import com.davidshalom.footballfollower.model.services.Resource
import retrofit2.Call
import retrofit2.Response

class FootballRepository(val context: Context, val footballService: FootballService, val competitionsDao: CompetitionDao) {

    fun getCompetitions(): LiveData<Resource<List<Competition>>> {

        val data = MutableLiveData<Resource<List<Competition>>>()
        val dbCount = competitionsDao.count()

        if (dbCount == 0) {
            data.value = Resource.loading(competitionsDao.all)

        } else {
            data.value = Resource.success(competitionsDao.all)
        }

        val call = footballService.getCompetitions()
        call.enqueue(object : retrofit2.Callback<List<Competition>> {
            override fun onResponse(call: Call<List<Competition>>?, response: Response<List<Competition>>) {
                if (response.isSuccessful) {
                    competitionsDao.insertAll(response.body())
                    data.setValue(Resource.success(competitionsDao.all))

                } else {
                    if (dbCount == 0) {
                        data.setValue(Resource.error("empty response"))
                    }
                }
            }

            override fun onFailure(call: Call<List<Competition>>?, t: Throwable?) {
                if (dbCount == 0) {
                    data.value = Resource.error(t.toString())
                }
            }
        })

        return data
    }
}

