package com.example.retrofittest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gory.repository.RetrofitRepository
import com.example.gory.viewmodel.WheaterViewModel

class FragmentViewModelFactory(private val retrofitRepository: RetrofitRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WheaterViewModel(retrofitRepository) as T
    }
}