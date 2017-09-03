package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.davidshalom.footballfollower.model.entities.Competition
import com.davidshalom.footballfollower.model.services.FootballService
import retrofit2.Call
import retrofit2.Response

class CompetitionsRepository(val footballService: FootballService) {
    fun getCompetitions(): LiveData<List<Competition>> {
        val data = MutableLiveData<List<Competition>>()

        var call = footballService.getCompetitions();
        call.enqueue(object : retrofit2.Callback<List<Competition>> {
            override fun onResponse(call: Call<List<Competition>>?, response: Response<List<Competition>>) {
                if (response.isSuccessful) {
                    data.setValue(response.body())
                };
            }
            override fun onFailure(call: Call<List<Competition>>?, t: Throwable?) {
                //data.setValue(t)
            }
        })
        return data
    }
}

