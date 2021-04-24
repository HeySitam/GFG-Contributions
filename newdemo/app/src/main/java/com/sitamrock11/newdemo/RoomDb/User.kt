package com.sitamrock11.newdemo.RoomDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val firstName:String,
    val lastName:String,
    val marks:String,
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L
)