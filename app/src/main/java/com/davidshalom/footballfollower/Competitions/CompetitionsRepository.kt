package com.davidshalom.footballfollower.Competitions

import android.util.Log
import com.davidshalom.footballfollower.model.services.FootballService

class CompetitionsRepository(val footballService: FootballService) {
    fun doit(){
        Log.e("dsds","do it CompetitionsRepository")
    }
}