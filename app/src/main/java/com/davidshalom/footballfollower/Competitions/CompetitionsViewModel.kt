package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.davidshalom.footballfollower.db.entities.Competition
import com.davidshalom.footballfollower.di.components.AppComponent

import javax.inject.Inject

class CompetitionsViewModel : ViewModel(), AppComponent.Injectable {
    var data: LiveData<List<Competition>>? = null
    @Inject lateinit var competitionsRepository: CompetitionsRepository

    override fun inject(countdownComponent: AppComponent) {
        countdownComponent.inject(this)
    }

    fun getCompetitions(): LiveData<List<Competition>> {
        if (data != null) {
            return data as LiveData<List<Competition>>
        }
        data = competitionsRepository.getCompetitions()
        return data as LiveData<List<Competition>>
    }
}
