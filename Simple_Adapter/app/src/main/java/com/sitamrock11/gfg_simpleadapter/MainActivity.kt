package com.sitamrock11.gfg_simpleadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import java.util.ArrayList
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    private lateinit var listView:ListView
    private val fruitNames=arrayOf("Banana","Grape","Guava","Mango","Orange","Watermelon") //String type array of names of different fruits
    private val fruitImageIds=arrayOf(R.drawable.banana,
                              R.drawable.grape,
                              R.drawable.guava,
                              R.drawable.mango,
                              R.drawable.orange,
                              R.drawable.watermelon)  //Integer type array of Ids of different fruits
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.listView)  // binding of ListView
        val list=ArrayList<HashMap<String,Any>>() //creating an ArrayList of HashMap
        for(i in fruitNames.indices){
            val map=HashMap<String,Any>()
            //Data entry in HashMap
            map["fruitName"] = fruitNames[i]
            map["fruitImage"]=fruitImageIds[i]
            list.add(map) //adding the HashMap to the ArrayList
        }
        val from=arrayOf("fruitName","fruitImage") // A string type array of column names for each View in each row of the list
        val to= intArrayOf(R.id.textView,R.id.imageView) // A integer type array of id of each View in each row of the list
        val simpleAdapter=SimpleAdapter(this,list,R.layout.list_row_items,from,to) // creating an object of SimpleAdapter class
        listView.adapter = simpleAdapter // setting simple adapter to the ListView
    }
}