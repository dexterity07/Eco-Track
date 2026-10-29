package com.example.eco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//TODO: MainAc
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isTaskRoot) {
            finish()
            return
        }
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, fragment::class.java)
            startActivity(intent)

        }//BADING


    }
}