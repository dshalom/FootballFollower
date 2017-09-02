package com.davidshalom.footballfollower.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.davidshalom.footballfollower.App
import com.davidshalom.footballfollower.di.components.AppComponent
import com.davidshalom.footballfollower.di.components.RepositoryComponent


class RepositoryFactory constructor(val application: App) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val t = super.create(modelClass)
        if (t is AppComponent.Injectable) {
            (t as AppComponent.Injectable).inject(application.component)
        }
        return t
    }
}