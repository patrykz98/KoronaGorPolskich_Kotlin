package com.example.gory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gory.fragment.*

class CardViewItemAgent: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val positionCardView: Int = intent.getIntExtra("position",0)

        if(positionCardView == 0)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, GalleryFragment()).commit()

        if(positionCardView == 1)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, MapsFragment()).commit()

        if(positionCardView == 2)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, AchievementFragment()).commit()

        if(positionCardView == 3)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, WheatherFragment()).commit()

        if(positionCardView == 4)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, InfoFragment()).commit()

        if(positionCardView == 5)
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, StampsFragment()).commit()



    }
}