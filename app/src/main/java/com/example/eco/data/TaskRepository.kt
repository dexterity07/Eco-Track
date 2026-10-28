package com.example.eco.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData

class TaskRepository (private val taskDao: TaskDao) {
     val readAllData: LiveData<List<Task>> = taskDao.getAllTask().asLiveData()


    suspend fun insert(task: Task){
        taskDao.insert(task)
    }

    suspend fun update(task: Task){
        taskDao.update(task)
    }

    suspend fun delete(task: Task){
        taskDao.delete(task)
    }
}