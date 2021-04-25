package com.sitamrock11.flexboxlayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.JustifyContent
import com.sitamrock11.flexboxlayout.R
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter

class JustifyContentFragment : Fragment() {
    lateinit var flexboxLayout: FlexboxLayout
    lateinit var btnJustifyContent: FabSpeedDial
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_justify_content, container, false)
        init(view)
        justifyContent()
        return view
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

    private fun init(view: View?) {
        btnJustifyContent = view!!.findViewById(R.id.btnJustifyContent)
        flexboxLayout= view!!.findViewById(R.id.flexboxLayout3)
    }
}