package com.example.gory.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gory.R
import com.example.gory.adapter.WheatherItemAdapter
import com.example.gory.databinding.FragmentWheatherBinding
import com.example.gory.repository.RetrofitRepository
import com.example.gory.viewmodel.WheaterViewModel
import com.example.retrofittest.FragmentViewModelFactory
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

const val BASE_URL = "https://api.openweathermap.org"

class WheatherFragment : Fragment() {

    private var _binding: FragmentWheatherBinding? = null
    private val binding get () = _binding!!
    private val latValues = arrayListOf("50.89211685609258",
                                        "50.865048228394336",
                                        "50.944094285290184",
                                        "50.45227979770458",
                                        "50.78045365290661",
                                        "50.257259696317895",
                                        "49.76708136073559",
                                        "50.48426517108458",
                                        "49.766327681478245",
                                        "50.680939713981175",
                                        "50.80864899280983",
                                        "50.25288636944188",
                                        "50.264200262507366",
                                        "49.427135501248785",
                                        "50.684927604788264",
                                        "49.4333094775025",
                                        "50.35071853086843",
                                        "50.24548224851119",
                                        "50.85070357998458",
                                        "49.65597974904006",
                                        "49.68508693586849",
                                        "49.450093117286556",
                                        "49.54344610675864",
                                        "49.075489628460105",
                                        "50.21328434672711",
                                        "50.73664091824822",
                                        "49.57396902136253",
                                        "49.17977")
    private val lonValues = arrayListOf("20.89652729828751",
                                        "16.708609841657445",
                                        "15.88468003774538",
                                        "16.753640878394627",
                                        "16.211987552567702",
                                        "17.42868197219536",
                                        "20.05958178637773",
                                        "16.343203891162712",
                                        "19.1552050631697",
                                        "16.27810472345634",
                                        "15.899964049444382",
                                        "16.564949988198798",
                                        "17.01388046247619",
                                        "21.1025899486808",
                                        "16.48648732669942",
                                        "20.44946087652411",
                                        "16.349811185244214",
                                        "16.97636103928281",
                                        "15.419401455536365",
                                        "20.276747739454148",
                                        "19.030290716189814",
                                        "20.60413137001527",
                                        "20.111387685416048",
                                        "22.726276817162653",
                                        "16.847346836461984",
                                        "15.739688178747647",
                                        "19.530882200778183",
                                        "20.08803")

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowBack.setOnClickListener{
            val fragment = MenuFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.commit()
        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return Math.round(this * multiplier) / multiplier
    }

    private fun setupRecyclerview() {
        var adapter = rvAdapter

        val simpleDateFormat = SimpleDateFormat("HH:mm", Locale.GERMANY)

        binding.recyclerViewWeather.adapter = adapter
        adapter.setOnItemClickListener(object: WheatherItemAdapter.OnItemClickListener{
            override fun onItemClick(humidity: Int, wind: Double, sunset: Int, sunrise: Int) {
                binding.textViewHumidity.text = (humidity.toString() + " %").takeIf { humidity.toString() != "0" }
                binding.textViewWind.text = ((wind * 1.609344).round(2).toString() + " km/h").takeIf { wind.toString() != "0.0" }
                var sunriseTime = simpleDateFormat.format(sunrise * 1000L).toString()
                var sunsetTime = simpleDateFormat.format(sunset * 1000L).toString()
                binding.textViewSunrise.text = sunriseTime.takeWhile { sunriseTime!="01:00" }
                binding.textViewSunset.text = sunsetTime.takeWhile { sunsetTime!="01:00" }

                if(binding.textViewHumidity.text.isEmpty()){
                    binding.textViewHumidity.text = "-- %"
                    binding.textViewWind.text = "-- km/h"
                    binding.textViewSunrise.text = "--"
                    binding.textViewSunset.text = "--"
                }

            }
        })
        binding.recyclerViewWeather.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }


}