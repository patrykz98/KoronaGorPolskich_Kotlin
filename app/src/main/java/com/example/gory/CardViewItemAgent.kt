package com.example.gory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CardViewItemAgent: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, MainDashboardFragment()).commit()

    }
}