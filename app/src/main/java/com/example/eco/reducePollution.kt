package com.example.eco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class reducePollution : AppCompatActivity() {
    private lateinit var pollution1: CheckBox
    private lateinit var pollution2: CheckBox
    private lateinit var pollution3: CheckBox

    private val prefs by lazy {
        getSharedPreferences("pollutionList", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.pollution)

        pollution1 = findViewById(R.id.pollution1)
        pollution2 = findViewById(R.id.pollution2)
        pollution2 = findViewById(R.id.pollution3)
        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
            finish()
        }

        pollution1.isChecked =
            prefs.getBoolean("pollution1", false)
        pollution2.isChecked =
            prefs.getBoolean("pollution2", false)
        pollution3.isChecked =
            prefs.getBoolean("pollution3", false)


        pollution1.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("pollution1", checked)
                .apply()
        }
        pollution2.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("pollution2", checked)
                .apply()
        }

        pollution3.setOnCheckedChangeListener { _, checked ->
            prefs.edit()
                .putBoolean("pollution3", checked)
                .apply()
        }
    }
}