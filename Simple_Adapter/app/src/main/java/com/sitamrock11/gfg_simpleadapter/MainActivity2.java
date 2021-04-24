package com.sitamrock11.gfg_simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    String fruitNames[]={"Banana","Grape","Guava","Mango","Orange","Watermelon"}; //String type array of names of different fruits
    int fruitImageIds[]={R.drawable.banana,
            R.drawable.grape,
            R.drawable.guava,
            R.drawable.mango,
            R.drawable.orange,
            R.drawable.watermelon}; //Integer type array of Ids of different fruits


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);   // binding of ListView
        ArrayList<HashMap<String,Object>> list= new ArrayList<>(); //creating an ArrayList of HashMap
        for(int i=0;i<fruitNames.length;i++){
            HashMap<String,Object> map=new HashMap<>();
            //Data entry in HashMap
            map.put("fruitName",fruitNames[i]);
            map.put("fruitImage",fruitImageIds[i]);
            list.add(map); //adding the HashMap to the ArrayList
        }
        String[] from={"fruitName","fruitImage"}; // A string type array of column names for each View in each row of the list
        int to[]={R.id.textView,R.id.imageView}; // A integer type array of id of each View in each row of the list
        SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),list,R.layout.list_row_items,from,to); // creating an object of SimpleAdapter class
        listView.setAdapter(simpleAdapter); // setting simple adapter to the ListView

    }
}