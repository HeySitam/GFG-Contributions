package com.sitamrock11.newdemo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


var Database_Name:String?="Student.db"
var Table_Name="student_table"
var Col_1="ID"
var Col_2="FirstName"
var Col_3="LastName"
var Col_4="Marks"

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, Database_Name, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $Table_Name ($Col_1 INTEGER PRIMARY KEY AUTOINCREMENT,$Col_2 TEXT,$Col_3 TEXT,$Col_4 FLOAT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $Table_Name")
        onCreate(db)
    }
    fun insertData(name: String?, surname: String?, marks: String?): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Col_2, name)
        contentValues.put(Col_3, surname)
        contentValues.put(Col_4, marks)
        val result = db.insert(Table_Name, null, contentValues)
        return result != -1L
    }

    fun getAllData(): Cursor? {
        val db = this.writableDatabase
        return db.rawQuery("select * from $Table_Name", null)
    }

}