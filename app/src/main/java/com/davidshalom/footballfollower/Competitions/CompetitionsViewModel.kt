package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.davidshalom.footballfollower.di.components.AppComponent
import com.davidshalom.footballfollower.model.entities.Competition
import javax.inject.Inject

class CompetitionsViewModel : ViewModel(), AppComponent.Injectable {
    var data: LiveData<ApiResponse<List<Competition>>>? = null
    @Inject lateinit var competitionsRepository: CompetitionsRepository

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    fun getCompetitions(): LiveData<ApiResponse<List<Competition>>> {
        if (data != null) {
            return data as LiveData<ApiResponse<List<Competition>>>
        }
        data = competitionsRepository.getCompetitions()
        return data as LiveData<ApiResponse<List<Competition>>>
    }
}
