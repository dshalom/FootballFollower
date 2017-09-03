package com.davidshalom.footballfollower.Competitions

import com.davidshalom.footballfollower.model.entities.Competition

class ApiResponse {
    var competitions: List<Competition>? = null
    var error: Throwable? = null

    constructor(competitions: List<Competition>?) {
        this.competitions = competitions
        this.error = null
    }

    constructor(error: Throwable) {
        this.error = error
        this.competitions = null
    }

}