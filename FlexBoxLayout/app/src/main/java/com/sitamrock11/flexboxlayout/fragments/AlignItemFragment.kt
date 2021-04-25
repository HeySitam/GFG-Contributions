package com.sitamrock11.flexboxlayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayout
import com.sitamrock11.flexboxlayout.R
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter


class AlignItemFragment : Fragment() {
    lateinit var flexboxLayout: FlexboxLayout
    lateinit var btnAlignItem: FabSpeedDial
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_align_item, container, false)
        init(view)
        alignItem()
        return view
    }

    private fun alignItem() {
        btnAlignItem.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                AlignItemSelected(menuItem)
                return true
            }
        })
    }

    private fun AlignItemSelected(menuItem: MenuItem) {
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

    private fun init(view: View?) {
        btnAlignItem = view!!.findViewById(R.id.btnAlignItem)
        flexboxLayout= view!!.findViewById(R.id.flexboxLayout4)
    }
}