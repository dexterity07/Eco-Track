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

        return view
    }

    private fun insertDataToDatabase(view: View) {
        val firstTaskEt = view.findViewById<EditText>(R.id.firstTask)

        val firstTask = firstTaskEt.text.toString()

        if (inputCheck(firstTask)) {
            val task = Task(0, firstTask)
            mTaskViewModel.insert(task)
            Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Plese fill your task", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstTask: String): Boolean {
        return !(TextUtils.isEmpty(firstTask))
    }
}
