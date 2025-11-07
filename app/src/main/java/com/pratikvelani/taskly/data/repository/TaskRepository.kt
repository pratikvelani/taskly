package com.pratikvelani.taskly.data.repository

import com.pratikvelani.taskly.data.model.TaskEntity

interface TaskRepository {

    suspend fun addTask(task: TaskEntity): Result<Unit>

    suspend fun getAllTasks(): Result<List<TaskEntity>>
}