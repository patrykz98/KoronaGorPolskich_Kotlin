package com.example.gory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gory.fragment.MainDashboardFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, MainDashboardFragment()).commit()

    }
}