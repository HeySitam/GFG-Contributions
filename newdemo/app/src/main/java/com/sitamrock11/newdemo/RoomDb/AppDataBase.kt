package com.sitamrock11.newdemo.RoomDb

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [User::class],version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
}