package com.sitamrock11.flexboxlayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout
import com.sitamrock11.flexboxlayout.R
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter

class FlexWrapFragment : Fragment() {
    lateinit var flexboxLayout: FlexboxLayout
    lateinit var btnFlexWrap: FabSpeedDial
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_flex_wrap, container, false)
        init(view)
        flexWrap()
        return view
    }

    private fun init(view: View?) {
        btnFlexWrap = view!!.findViewById(R.id.btnFlexWrap)
        flexboxLayout= view!!.findViewById(R.id.flexboxLayout2)
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
}