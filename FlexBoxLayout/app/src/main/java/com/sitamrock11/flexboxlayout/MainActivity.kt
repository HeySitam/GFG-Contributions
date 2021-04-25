package com.sitamrock11.flexboxlayout

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.Visibility
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.flexbox.*
import com.google.android.material.appbar.MaterialToolbar
import com.sitamrock11.flexboxlayout.fragments.*
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter

class MainActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener {
    lateinit var imgPlay: ImageView
    lateinit var txtPlay: TextView
    lateinit var topAppBar: MaterialToolbar
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setSupportActionBar(topAppBar)
        topAppBar.setOnMenuItemClickListener(this)
        txtPlay.setOnClickListener{
            supportActionBar?.openOptionsMenu()
        }
    }

    private fun init() {
        topAppBar = findViewById(R.id.topAppBar)
        imgPlay=findViewById(R.id.imgPlay)
        txtPlay=findViewById(R.id.txtPlay)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.attribute_menu, menu)
        return true
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        imgPlay.visibility= View.GONE
        txtPlay.visibility=View.GONE
        Toast.makeText(this, "${item!!.title} selected", Toast.LENGTH_SHORT).show()
        when(item?.itemId){
            R.id.itemFlexDirection->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, FlexDirectionFragment())
                    .commit()
            }
            R.id.itemFlexWrap->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, FlexWrapFragment())
                    .commit()
            }
            R.id.itemJustifyContent->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, JustifyContentFragment())
                    .commit()
            }
            R.id.itemAlignItem->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, AlignItemFragment())
                    .commit()
            }
            R.id.itemAlignContent->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, AlignContentFragment())
                    .commit()
            }
        }
        return false

    }
}