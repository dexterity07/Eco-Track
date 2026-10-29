package com.example.eco.data

import android.os.Parcelable
import androidx.room3.Entity
import androidx.room3.Index
import androidx.room3.PrimaryKey




@Entity(
    tableName = "task",
    indices = [Index(value = ["task"], unique = true)])

data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String,
    var qt: Int

    //val progress: Boolean = false

)