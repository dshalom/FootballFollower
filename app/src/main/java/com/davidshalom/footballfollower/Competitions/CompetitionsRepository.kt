package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.davidshalom.footballfollower.model.entities.Competition
import com.davidshalom.footballfollower.model.services.FootballService
import retrofit2.Call
import retrofit2.Response

class CompetitionsRepository(val footballService: FootballService) {
    fun getCompetitions(): LiveData<ApiResponse<List<Competition>>> {
        val data = MutableLiveData<ApiResponse<List<Competition>>>()

        var call = footballService.getCompetitions()
        call.enqueue(object : retrofit2.Callback<List<Competition>> {
            override fun onResponse(call: Call<List<Competition>>?, response: Response<List<Competition>>) {
                if (response.isSuccessful) {
                    var res = ApiResponse<List<Competition>>()
                    res.data = response.body()
                    data.setValue(res)
                } else {
                    var res = ApiResponse<List<Competition>>()
                    res.error = NoSuchElementException()
                    data.setValue(res)
                }
            }
            override fun onFailure(call: Call<List<Competition>>?, t: Throwable?) {
                var res = ApiResponse<List<Competition>>()
                res.error = t
                data.setValue(res)
            }
        })
        return data
    }
}

