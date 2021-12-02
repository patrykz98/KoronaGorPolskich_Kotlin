package com.example.gory.repository

import com.example.gory.api.RetrofitInstance
import com.example.gory.api.WheaterJson
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse

class RetrofitRepository {

    suspend fun getWheather(latValue: String, lonValue: String): Response<WheaterJson> {
        return RetrofitInstance.api.getWeather(latValue, lonValue, "79e5aba6a5eee55f80289a4e415ef9dd").awaitResponse()
    }

}