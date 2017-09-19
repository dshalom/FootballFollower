package com.davidshalom.footballfollower.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.davidshalom.footballfollower.model.db.entities.Competition
import com.davidshalom.footballfollower.model.db.entities.CompetitionDao
import com.davidshalom.footballfollower.model.services.FootballService
import com.davidshalom.footballfollower.model.services.Resource
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FootballRepository(val context: Context, val footballService: FootballService, val competitionsDao: CompetitionDao) {

    private lateinit var dbData: List<Competition>
    private val data = MutableLiveData<Resource<List<Competition>>>()

    fun getCompetitions(): LiveData<Resource<List<Competition>>> {


        doAsync {
            // Do some work
            dbData = competitionsDao.all
            uiThread {
                data.value = Resource.loading(dbData)
            }
        }

        doAsync {
            try {
                val response = footballService.getCompetitions().execute()
                if (response.isSuccessful) {
                    competitionsDao.insertAll(response.body())
                    uiThread {
                        data.setValue(Resource.success(response.body()))
                    }
                } else {
                    uiThread { handleError() }
                }
            } catch (e: Exception) {
                uiThread {
                    uiThread { handleError() }
                }
            }
        }
        return data
    }

    fun handleError() {
        if (dbData.size == 0) {
            data.setValue(Resource.error("empty response"))

        } else {
            data.setValue(Resource.success(dbData))
        }
    }
}


