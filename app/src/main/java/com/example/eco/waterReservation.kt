package com.example.eco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class waterReservation : AppCompatActivity(){
    private lateinit var water1: CheckBox
    private lateinit var water2: CheckBox
    private lateinit var water3: CheckBox

    private val prefs by lazy {
        getSharedPreferences("waterList", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.water)

        water1 = findViewById(R.id.pollution1)
        water2 = findViewById(R.id.pollution2)
        water3 = findViewById(R.id.pollution3)
        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
            finish()
        }

        water1.isChecked =
            prefs.getBoolean("water1", false)
        water2.isChecked =
            prefs.getBoolean("water2", false)
        water3.isChecked =
            prefs.getBoolean("water3", false)


        water1.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("water1", checked)
                .apply()
        }
        water2.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("water2", checked)
                .apply()
        }

        water3.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("water3", checked)
                .apply()
        }
    }
}