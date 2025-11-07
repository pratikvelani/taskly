package com.pratikvelani.taskly.data.local

import com.pratikvelani.taskly.data.model.TaskEntity

interface SharedPrefsApi {

    fun addTask(task: TaskEntity)

    fun getAllTasks(): List<TaskEntity>

    fun updateTask(uuid: String, task: TaskEntity)
}