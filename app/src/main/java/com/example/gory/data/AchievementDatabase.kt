package com.example.gory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Achievement::class], version = 1,exportSchema = false)
abstract class AchievementDatabase: RoomDatabase() {

    companion object{
        var achievementDatabase: AchievementDatabase? = null

        @Synchronized
        fun getDatabse(context: Context): AchievementDatabase{
            if(achievementDatabase == null){
                achievementDatabase = Room.databaseBuilder(
                    context,
                    AchievementDatabase::class.java,
                    "achievement.db"
                ).build()
            }
            return achievementDatabase!!
        }

    }

    abstract fun achievementDao(): AchievementDao

}