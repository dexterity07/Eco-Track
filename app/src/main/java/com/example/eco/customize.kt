package com.example.eco

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.eco.data.Task
import com.example.eco.data.TaskViewModel


class customize : Fragment() {

    private lateinit var mTaskViewModel: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_customize, container, false)

        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        val addBtn = view.findViewById<Button>(R.id.addBtn)
        addBtn.setOnClickListener {

            insertDataToDatabase(view)
        }
        val btn2 = view.findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {

            insertDataToDatabase2(view)
        }

        return view
    }

    private fun insertDataToDatabase(view: View) {
       // val firstTaskEt = view.findViewById<EditText>(R.id.firstTask)

        val firstTask = "SAPATOS"//firstTaskEt.text.toString()
        val quantity = 1
        if (firstTask!=null) {
            val task = Task(0, firstTask, quantity)
            mTaskViewModel.insert(task)
            Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Please fill your task", Toast.LENGTH_LONG).show()
        }
    }

    private fun insertDataToDatabase2(view: View) {
        //val firstTaskEt = view.findViewById<EditText>(R.id.firstTask)

        val firstTask2 = "KAHOY"//firstTaskEt.text.toString()
        val quantity = 1
        if (firstTask2!=null) {
            val task = Task(0, firstTask2, quantity)
            mTaskViewModel.insert(task)
            Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Please fill your task", Toast.LENGTH_LONG).show()
        }
    }

   /* private fun inputCheck(firstTask: String): Boolean {
        return !(TextUtils.isEmpty(firstTask))
    }*/
}
