package com.sitamrock11.flexboxlayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayout
import com.sitamrock11.flexboxlayout.R
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter

class FlexDirectionFragment : Fragment() {
    lateinit var flexboxLayout: FlexboxLayout
    lateinit var btnFlexDirection: FabSpeedDial
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_flex_direction, container, false)
        init(view)
        flexDirection()
        return view
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

    private fun init(view:View) {
        btnFlexDirection = view.findViewById(R.id.btnFlexDirection)
        flexboxLayout= view.findViewById(R.id.flexboxLayout1)
    }
}