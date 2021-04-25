package com.sitamrock11.flexboxlayout

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.flexbox.*
import com.google.android.material.appbar.MaterialToolbar
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter

class MainActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener {
    lateinit var flexboxLayout: FlexboxLayout
    lateinit var btnFlexDirection: FabSpeedDial
    lateinit var btnFlexWrap: FabSpeedDial
    lateinit var btnJustifyContent: FabSpeedDial
    lateinit var btnAlignItem: FabSpeedDial
    lateinit var btnAlignContent: FabSpeedDial
    lateinit var topAppBar: MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flexboxLayout = findViewById(R.id.flexbox_layout)
        init()
        setSupportActionBar(topAppBar)
        topAppBar.setOnMenuItemClickListener(this)
        flexDirection()
        flexWrap()
        justifyContent()
        alignItem()
        alignContent()

    }

    private fun alignContent() {
        btnAlignContent.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                alignContentItemSelected(menuItem)
                return true
            }
        })
    }

    private fun alignContentItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.flex_start_content -> {
                flexboxLayout.alignContent = AlignContent.FLEX_START
            }
            R.id.flex_end_content -> {
                flexboxLayout.alignContent = AlignContent.FLEX_END
            }
            R.id.center_content -> {
                flexboxLayout.alignContent = AlignContent.CENTER
            }
            R.id.space_between_content -> {
                flexboxLayout.alignContent = AlignContent.SPACE_BETWEEN
            }
            R.id.space_around_content -> {
                flexboxLayout.alignContent = AlignContent.SPACE_AROUND
            }
        }
    }

    private fun alignItem() {
        btnAlignItem.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                alignItemSelected(menuItem)
                return true
            }
        })
    }

    private fun alignItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.flex_start_align -> {
                flexboxLayout.alignItems = AlignItems.FLEX_START
            }
            R.id.flex_end_align -> {
                flexboxLayout.alignItems = AlignItems.FLEX_END
            }
            R.id.center_align -> {
                flexboxLayout.alignItems = AlignItems.CENTER
            }
            R.id.baseline_align -> {
                flexboxLayout.alignItems = AlignItems.BASELINE
            }
            R.id.stretch_align -> {
                flexboxLayout.alignItems = AlignItems.STRETCH
            }
        }
    }

    private fun justifyContent() {
        btnJustifyContent.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                justifyContentItemSelected(menuItem)
                return true
            }
        })
    }

    private fun justifyContentItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.flex_start -> {
                flexboxLayout.justifyContent = JustifyContent.FLEX_START
            }
            R.id.flex_end -> {
                flexboxLayout.justifyContent = JustifyContent.FLEX_END
            }
            R.id.center -> {
                flexboxLayout.justifyContent = JustifyContent.CENTER
            }
            R.id.space_between -> {
                flexboxLayout.justifyContent = JustifyContent.SPACE_BETWEEN
            }
            R.id.space_around -> {
                flexboxLayout.justifyContent = JustifyContent.SPACE_AROUND
            }
        }
    }

    private fun flexWrap() {
        btnFlexWrap.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                flexWrapItemSelected(menuItem)
                return true
            }
        })
    }

    private fun flexWrapItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.noWrap -> {
                flexboxLayout.flexWrap = FlexWrap.NOWRAP
            }
            R.id.menuWrap -> {
                flexboxLayout.flexWrap = FlexWrap.WRAP
            }
            R.id.wrapReverse -> {
                flexboxLayout.flexWrap = FlexWrap.WRAP_REVERSE
            }
        }

    }

    private fun flexDirection() {
        btnFlexDirection.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                flexDirectionItemSelected(menuItem)
                return true
            }
        })
    }

    private fun flexDirectionItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.row -> {
                flexboxLayout.flexDirection = FlexDirection.ROW
            }
            R.id.row_reverse -> {
                flexboxLayout.flexDirection = FlexDirection.ROW_REVERSE
            }
            R.id.column -> {
                flexboxLayout.flexDirection = FlexDirection.COLUMN
            }
            R.id.column_reverse -> {
                flexboxLayout.flexDirection = FlexDirection.COLUMN_REVERSE
            }
        }

    }

    private fun init() {
        btnFlexDirection = findViewById(R.id.btnFlexDirection)
        btnFlexWrap = findViewById(R.id.btnFlexWrap)
        btnJustifyContent = findViewById(R.id.btnJustifyContent)
        btnAlignItem = findViewById(R.id.btnAlignItem)
        btnAlignContent = findViewById(R.id.btnAlignContent)
        topAppBar = findViewById(R.id.topAppBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.align_content_menu, menu)
        return true
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        Toast.makeText(this, "${item!!.title} selected", Toast.LENGTH_SHORT).show()
        return false

    }
}