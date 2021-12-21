package com.example.gory.fragment

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gory.R
import com.example.gory.data.Achievement
import com.example.gory.data.AchievementDatabase
import com.example.gory.databinding.FragmentCreateAchievementBinding
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CreateAchievementFragment : BaseFragment() {

    private var _binding: FragmentCreateAchievementBinding? = null
    private val binding get () = _binding!!
    private lateinit var imageURI: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateAchievementBinding.inflate(inflater, container, false)

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        binding.buttonSetDate.setOnClickListener {
            DatePickerDialog(it.context, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        return binding.root
    }

    fun updateLabel(myCalendar: Calendar){
        val sdf = SimpleDateFormat("dd/M/yyyy", Locale.GERMANY)
        binding.textViewDate.setText(sdf.format(myCalendar.time))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        binding.buttonAddImage.setOnClickListener {
            pickImageFromGallery()
        }
    }

    private fun pickImageFromGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100){
            binding.imageViewFromGallery.setImageURI(data?.data)
            imageURI = data?.data.toString()
        }
    }

    private fun saveNote(){

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
            achievement.imgPath = imageURI
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