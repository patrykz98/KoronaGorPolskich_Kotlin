package com.example.gory.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gory.R
import com.example.gory.data.Achievement
import com.example.gory.data.AchievementDatabase
import com.example.gory.databinding.FragmentCreateAchievementBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CreateAchievementFragment : BaseFragment() {

    private var _binding: FragmentCreateAchievementBinding? = null
    private val binding get () = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateAchievementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        binding.textViewDate.text = currentDate

        binding.arrowBack.setOnClickListener{
            val fragment = AchievementFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)
                ?.commit()
        }

        binding.saveAchievment.setOnClickListener{
            saveNote()
            val fragment = AchievementFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)
                ?.commit()
        }
    }

    private fun saveNote(){

//        if(binding.editTextAchievementDesc.text.isNullOrEmpty())
//            Toast.makeText(context, "Podaj datę!", Toast.LENGTH_SHORT).show()

        if(binding.editTextAchievementPlace.text.isNullOrEmpty())
            Toast.makeText(context, "Podaj nazwę szczytu!", Toast.LENGTH_SHORT).show()

        if(binding.editTextAchievementTime.text.isNullOrEmpty())
            Toast.makeText(context, "Podaj czas wejścia!", Toast.LENGTH_SHORT).show()

        launch {
            val achievement = Achievement()
            achievement.place = binding.editTextAchievementPlace.text.toString()
            achievement.description = binding.editTextAchievementDesc.text.toString()
            achievement.time = binding.editTextAchievementTime.text.toString()
            achievement.date = binding.textViewDate.text.toString()
            context?.let{
                AchievementDatabase.getDatabse(it).achievementDao().insertAchievement(achievement)
                binding.editTextAchievementPlace.setText("")
                binding.editTextAchievementDesc.setText("")
                binding.editTextAchievementTime.setText("")
                binding.textViewDate.setText("")

            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}