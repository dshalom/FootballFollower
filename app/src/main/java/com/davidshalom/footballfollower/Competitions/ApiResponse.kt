package com.davidshalom.footballfollower.Competitions

class ApiResponse<T> {
    var data: T? = null
    var error: Throwable? = null

    fun onSuccess(competitions: T?) {
        this.data = competitions
        this.error = null
    }

    fun onError(error: Throwable) {
        this.error = error
        this.data = null
    }
}