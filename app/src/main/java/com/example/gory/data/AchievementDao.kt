package com.example.gory.data

import androidx.room.*

@Dao
interface AchievementDao {

    @Query("SELECT * FROM Achievement ORDER BY id DESC")
    suspend fun getAllAchievement() : List<Achievement>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAchievement(achievement: Achievement)

    @Delete
    suspend fun deleteAchievement(achievement: Achievement)

}