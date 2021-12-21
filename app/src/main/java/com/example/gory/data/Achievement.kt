package com.example.gory.data

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Achievement")
class Achievement: Serializable {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    @ColumnInfo(name = "place")
    var place:String? = null

    @ColumnInfo(name = "description")
    var description:String? = null

    @ColumnInfo(name = "date")
    var date:String? = null

    @ColumnInfo(name = "time")
    var time:String? = null

    @ColumnInfo(name = "img_path")
    var imgPath:String? = null


    override fun toString(): String {
        return "$place : $time"
    }


}