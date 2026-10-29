package com.example.eco

import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.eco.data.TaskViewModel


class home : Fragment() {

   private lateinit var wasteText: TextView
   private lateinit var polText: TextView
   private lateinit var taskPercentt: TextView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)



    }
//  override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    wasteText = view.findViewById(R.id.wasteText)
        polText = view.findViewById(R.id.polText)
        taskPercentt = view.findViewById(R.id.taskPercent)
        val category1 = view.findViewById<ImageView>(R.id.category1)
        val category2 = view.findViewById<ImageView>(R.id.category2)
        val category6 = view.findViewById<ImageView>(R.id.category6)

        category1.setOnClickListener {
            val intent = Intent(requireActivity(), wasteManagement::class.java)
            startActivity(intent)
        }

        category2.setOnClickListener {
            val intent = Intent(requireActivity(), waterReservation::class.java)
            startActivity(intent)
        }

        category6.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_container, list())
                .addToBackStack(null)
                .commit()
        }

//
//
//}
    }
   override fun onResume() {
        super.onResume()
       updaterWaste()

    }

   fun updaterWaste() {
      var prefs = requireContext().getSharedPreferences("wasteList", Context.MODE_PRIVATE)

      val waste1 = prefs.getBoolean("waste1", false)
      val waste2 = prefs.getBoolean("waste2", false)
      val waste3 = prefs.getBoolean("waste3", false)

       //water
       val wat1 = prefs.getBoolean("water1", false)
       val wat2 = prefs.getBoolean("water2", false)
       val wat3 = prefs.getBoolean("water3", false)


        val progressWaste = listOf(
            waste1, waste2, waste3
       ).count { it }

       wasteText.text = when (progressWaste){
            0 -> "NOT STARTED"
            3 -> "COMPLETED"
            else -> "IN PROGRESS"

        }

       val progressPollution = listOf(
           wat1, wat2, wat3
       ).count { it }

       polText.text = when (progressPollution){
           0 -> "NOT STARTED"
           3 -> "COMPLETED"
           else -> "IN PROGRESS"
       }

       val taskCount = 6
       val taskPercent = ((progressWaste + progressPollution) * 100) / taskCount

       taskPercentt.text = "${taskPercent}%"
    }

//    fun updaterWater() {
//        var prefs = requireContext().getSharedPreferences("waterList", Context.MODE_PRIVATE)





    }




