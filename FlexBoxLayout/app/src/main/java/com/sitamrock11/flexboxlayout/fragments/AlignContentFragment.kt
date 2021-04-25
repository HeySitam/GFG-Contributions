package com.sitamrock11.flexboxlayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.flexbox.AlignContent
import com.google.android.flexbox.FlexboxLayout
import com.sitamrock11.flexboxlayout.R
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter

class AlignContentFragment : Fragment() {
    lateinit var flexboxLayout: FlexboxLayout
    lateinit var btnAlignContent: FabSpeedDial
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_align_content, container, false)
        init(view)
        alignContent()
        return view
    }

    private fun alignContent() {
        btnAlignContent.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                AlignContentItemSelected(menuItem)
                return true
            }
        })
    }

    private fun AlignContentItemSelected(menuItem: MenuItem) {
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

    private fun init(view: View?) {
        btnAlignContent = view!!.findViewById(R.id.btnAlignContent)
        flexboxLayout= view!!.findViewById(R.id.flexboxLayout5)
    }
}