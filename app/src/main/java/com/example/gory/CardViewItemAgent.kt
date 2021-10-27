package com.example.gory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CardViewItemAgent: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val positionCardView: Int = intent.getIntExtra("position",0)

        if(positionCardView == 0)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, GalleryFragment()).commit()

        if(positionCardView == 1)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, MapsFragment()).commit()




    }
}