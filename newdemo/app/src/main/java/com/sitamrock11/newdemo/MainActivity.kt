package com.sitamrock11.newdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        btnLetCount.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(R.id.flContainer,FragmentCountDown()).commit()
//        }
        val bundle=Bundle()
        bundle.putString("KEY","Rupu")
        val fragment=FragmentCountUp()
        fragment.arguments=bundle
        val viewPagerAdapter=ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.apply{
            add(FragmentCountUp())
            add(FragmentCountDown())
        }
        viewPager.adapter=viewPagerAdapter
        val psr=PowerStateReceiver()
        val iFilter= IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(psr,iFilter)
    }
    inner class PowerStateReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"Power state changed",Toast.LENGTH_SHORT).show()
        }

    }
}


