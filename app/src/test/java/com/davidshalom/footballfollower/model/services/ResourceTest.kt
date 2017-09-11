package com.davidshalom.footballfollower.model.services

import org.junit.Test

class ResourceTest {
    @Test
    fun onSuccess() {
        val resource = Resource.success("test")
        assert(resource.status == Resource.Status.SUCCESS)
        assert(resource.data.equals("test"))
        assert(resource.exception.equals(null))

    }


    @Test
    fun onError() {
        val resource = Resource.error<String>("error")
        assert(resource.status == Resource.Status.ERROR)
        assert(resource.data.equals(null))
        assert(resource.exception.equals("error"))
    }

}