package com.davidshalom.footballfollower.model.services

import com.davidshalom.footballfollower.model.db.entities.Competition
import retrofit2.Call
import retrofit2.http.GET

interface FootballService {

    @GET("competitions")
    fun getCompetitions(): Call<List<Competition>>

}