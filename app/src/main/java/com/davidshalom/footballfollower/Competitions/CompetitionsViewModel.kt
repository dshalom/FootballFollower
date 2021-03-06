package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.davidshalom.footballfollower.di.components.AppComponent
import com.davidshalom.footballfollower.model.FootballRepository
import com.davidshalom.footballfollower.model.db.entities.Competition
import com.davidshalom.footballfollower.model.services.Resource
import javax.inject.Inject

class CompetitionsViewModel : ViewModel(), AppComponent.Injectable {
    var data: LiveData<Resource<List<Competition>>>? = null
    @Inject lateinit var competitionsRepository: FootballRepository

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    fun getCompetitions(): LiveData<Resource<List<Competition>>> {
        if (data != null) {
            return data as LiveData<Resource<List<Competition>>>
        }
        data = competitionsRepository.getCompetitions()
        return data as LiveData<Resource<List<Competition>>>
    }
}
