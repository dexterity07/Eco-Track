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
        val category1 = view.findViewById<ImageView>(R.id.category1)
        //val category6 = view.findViewById<ImageView>(R.id.category6)


        category1.setOnClickListener {
            val intent = Intent(requireActivity(), wasteManagement::class.java)
            startActivity(intent)
        }

        view.findViewById<ImageView>(R.id.category6).setOnClickListener {
            findNavController().navigate(
                R.id.action_home2_to_list
            )
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


        val progressWaste = listOf(
            waste1, waste2, waste3
       ).count { it }

       wasteText.text = when (progressWaste){
            0 -> "NOT STARTED"
            3 -> "COMPLETED"
            else -> "IN PROGRESS"
        }
    }
}

