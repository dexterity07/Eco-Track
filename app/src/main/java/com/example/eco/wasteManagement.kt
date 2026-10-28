package com.example.eco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class wasteManagement: AppCompatActivity() {

    private lateinit var waste1: CheckBox
    private lateinit var waste2: CheckBox
    private lateinit var waste3: CheckBox

    private val prefs by lazy {
        getSharedPreferences("wasteList", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.waste_management)

        waste1 = findViewById(R.id.waste1)
        waste2 = findViewById(R.id.waste3)
        waste3 = findViewById(R.id.waste2)
        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
            finish()
        }

        waste1.isChecked =
            prefs.getBoolean("waste1", false)
        waste2.isChecked =
            prefs.getBoolean("waste2", false)
        waste3.isChecked =
            prefs.getBoolean("waste3", false)


        waste1.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("waste1", checked)
                .apply()
        }
        waste2.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("waste2", checked)
                .apply()
        }

        waste3.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("waste3", checked)
                .apply()
        }
}
}
