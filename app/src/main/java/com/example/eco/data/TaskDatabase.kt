package com.example.eco.data

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase

@Database(entities = [Task::class], version = 4, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object{
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase{
            val tempInstance = INSTANCE

            if (tempInstance!=null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, TaskDatabase::class.java, "task_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}