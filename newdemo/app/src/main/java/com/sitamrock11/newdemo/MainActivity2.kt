package com.sitamrock11.newdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.sitamrock11.newdemo.RoomDb.AppDataBase
import com.sitamrock11.newdemo.RoomDb.User
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
   // val dbHelp=DatabaseHelper(this)

    val db by lazy{
        Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "StudentMarksheet.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Alarm manager
//        btnOpenActivity.setOnClickListener {
//            val intent = Intent(baseContext, MainActivity::class.java)
//            val pi = PendingIntent.getActivity(baseContext, 9062, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 3000,3000, pi)
//        }
       // val dbHelp=DatabaseHelper(this)


        //RoomDb implementation


        btnAddData.setOnClickListener {
            db.userDao().insert(User(etFirstName.text.toString(), etSurName.text.toString(), etMarks.text.toString()))
        }

        btnViewAllData.setOnClickListener {
            val list=db.userDao().getAllUser()
            if(list.isNotEmpty()){
                with(list[0]){
                    var str="""
                        $firstName
                        $lastName
                        $marks
                        
                        
                        
                    """.trimIndent()
                    showMessage("Data",str)
                }
            }
        }



    //SQLite implementation
//        btnAddData.setOnClickListener {
//           var isInserted= dbHelp.insertData(etFirstName.text.toString(), etSurName.text.toString(), etMarks.text.toString())
//            if(isInserted)
//                Toast.makeText(this, "Data Inserted!", Toast.LENGTH_SHORT).show()
//            else
//                Toast.makeText(this, "Data not Inserted!", Toast.LENGTH_SHORT).show()
//        }
//        viewAll()
    }
//    fun viewAll(){
//        btnViewAllData.setOnClickListener {
//            var res=dbHelp.getAllData()
//            if(res?.count ==0){
//                showMessage("Error", "Nothing Found")
//            }else{
//                val buffer = StringBuffer()
//                while (res!!.moveToNext()) {
//                    buffer.append("""
//                        ID: ${res!!.getString(0)}
//                        Name: ${res!!.getString(1)}
//                        Surname: ${res!!.getString(2)}
//                        Marks: ${res!!.getString(3)}
//
//
//                    """.trimIndent())
//                }
//
//                // Show all data
//
//                // Show all data
//                showMessage("Data", buffer.toString())
//            }
//        }
//    }
    private fun showMessage(title: String?, Message: String?) {
        val builder= AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }
}