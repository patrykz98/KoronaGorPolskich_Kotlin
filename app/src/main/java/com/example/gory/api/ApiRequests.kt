package com.example.gory.api

import com.example.gory.api.WheaterJson
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequests {

    @GET("/data/2.5/weather")
    fun getWeather(
        @Query("lat") latValue: String,
        @Query("lon") lonValue: String,
        @Query("appid") apiId: String
        ): Call<WheaterJson>


}