package com.example.gory.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gory.api.WheaterJson
import com.example.gory.repository.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class WheaterViewModel(private val retrofitRepository: RetrofitRepository): ViewModel() {

    var wheaterResponse: MutableLiveData<Response<WheaterJson>> = MutableLiveData()

    fun getWheater(latValue: String, lonValue: String){
        viewModelScope.launch {
            val response = retrofitRepository.getWheather(latValue,lonValue)
            wheaterResponse.value = response
        }
    }

}