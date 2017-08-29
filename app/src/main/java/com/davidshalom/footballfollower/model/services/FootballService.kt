package com.davidshalom.footballfollower.model.services

import com.davidshalom.footballfollower.model.entities.Competition
import io.reactivex.Single
import retrofit2.http.GET

interface FootballService {

    @GET("competitions")
    fun getCompetitions(): Single<List<Competition>>

}