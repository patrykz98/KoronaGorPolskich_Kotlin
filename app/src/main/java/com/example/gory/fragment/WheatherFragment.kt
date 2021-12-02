package com.example.gory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gory.R
import com.example.gory.adapter.WheatherItemAdapter
import com.example.gory.data.WheaterItem
import com.example.gory.databinding.FragmentWheatherBinding
import com.example.gory.repository.RetrofitRepository
import com.example.gory.viewmodel.WheaterViewModel
import com.example.retrofittest.FragmentViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

const val BASE_URL = "https://api.openweathermap.org"

class WheatherFragment : Fragment() {

    private var _binding: FragmentWheatherBinding? = null
    private val binding get () = _binding!!

    private val latValues = arrayListOf("49.65597974904006","49.17977")
    private val lonValues = arrayListOf("20.276747739454148","20.08803")

    private lateinit var viewModel: WheaterViewModel
    private val rvAdapter by lazy {
        WheatherItemAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWheatherBinding.inflate(inflater, container, false)

        setupRecyclerview()

        var retrofitRepository = RetrofitRepository()
        val viewModelFactory = FragmentViewModelFactory(retrofitRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(WheaterViewModel::class.java)
        for(i in 0..latValues.size-1) {
            viewModel.getWheater(latValues[i], lonValues[i])
        }
            viewModel.wheaterResponse.observe(viewLifecycleOwner, Observer { response ->
                if(response.isSuccessful){
                    response.body()?.let {
                        rvAdapter.setData(it)
                    }
                }
            })

//        GlobalScope.launch(Dispatchers.IO) {
//            val response = retrofitRepository.getWheather(latValues[0],lonValues[0]).awaitResponse()
//            if(response.isSuccessful){
//                val data = response.body()!!
//
//                withContext(Dispatchers.Main){
//                    rvAdapter.setData(data)
//                }
//            }
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowBack.setOnClickListener{
            val fragment = MenuFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.commit()
        }

        binding.textViewTemperature.setOnClickListener{
            getWeather()
        }
    }

    private fun setupRecyclerview() {
        binding.recyclerViewWeather.adapter = rvAdapter
        binding.recyclerViewWeather.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun getWeather() {


    }


}