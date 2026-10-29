package com.example.eco

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible


class achievment : Fragment() {


    private lateinit var a1: ImageView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_achievment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



     a1 = view.findViewById<ImageView>(R.id.a1)




    }

    override fun onResume() {
        super.onResume()
        achievementUpdate()
    }
    //achievementupdate
    fun achievementUpdate(){
        val prefs = requireContext().getSharedPreferences("wasteList", Context.MODE_PRIVATE)
        val ach1 = prefs.getBoolean("waste1", false)
        val ach2 = prefs.getBoolean("waste2", false)
        val ach3 = prefs.getBoolean("waste3", false)

        val achievement = listOf(
            ach3, ach1, ach2
        ).count {it}

        when (achievement) {
            3 ->
            a1.visibility = View.VISIBLE

        }
    }




}