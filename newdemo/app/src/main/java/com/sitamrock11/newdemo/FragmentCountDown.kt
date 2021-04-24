package com.sitamrock11.newdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentCountDown.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentCountDown : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var x=0
        val fragmentView=inflater.inflate(R.layout.fragment_count_down, container, false)
        val btnMinus= fragmentView?.findViewById<Button>(R.id.btnMinus)
        val tvMinus=fragmentView?.findViewById<TextView>(R.id.tvMinus)
       btnMinus?.setOnClickListener {
           x++
           tvMinus?.text = x.toString()

       }
        return fragmentView
    }

}