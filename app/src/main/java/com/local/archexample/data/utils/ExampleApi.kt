package com.local.archexample.data.utils

import com.local.archexample.data.models.ImageData
import retrofit2.Call
import retrofit2.http.GET

interface ExampleApi {
    @GET("/floof")
    fun floof(): Call<ImageData>
}