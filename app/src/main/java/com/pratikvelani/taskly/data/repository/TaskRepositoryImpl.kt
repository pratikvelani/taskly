package com.pratikvelani.taskly.data.repository

import com.pratikvelani.taskly.data.local.SharedPrefsApi
import com.pratikvelani.taskly.data.model.TaskEntity
import javax.inject.Inject

internal class TaskRepositoryImpl @Inject constructor(
    private val sharedPrefsApi: SharedPrefsApi,
): TaskRepository {

    override suspend fun addTask(task: TaskEntity): Result<Unit> = runCatching {
        sharedPrefsApi.addTask(task)
    }

    override suspend fun getAllTasks(): Result<List<TaskEntity>> = runCatching {
        sharedPrefsApi.getAllTasks()
    }
}