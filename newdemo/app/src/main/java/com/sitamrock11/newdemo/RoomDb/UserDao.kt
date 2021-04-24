package com.sitamrock11.newdemo.RoomDb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user:User)
    @Delete
    fun delete(user:User)
    @Query(" SELECT * FROM User")
    fun getAllUser():List<User>
}