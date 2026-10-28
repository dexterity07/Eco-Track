package com.example.eco.data

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "task")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String,
    val progress: Boolean = false

)