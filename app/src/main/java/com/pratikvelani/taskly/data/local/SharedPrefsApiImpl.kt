package com.pratikvelani.taskly.data.local

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pratikvelani.taskly.data.model.TaskEntity
import java.lang.reflect.Type
import javax.inject.Inject


private const val PREFS_NAME = "tasks_prefs"
private const val TASKS_KEY = "tasks"

private val taskEntityListType: Type = object : TypeToken<List<TaskEntity>>() {}.getType()

class SharedPrefsApiImpl @Inject constructor(
    private val gson: Gson,
    private val context: Context
): SharedPrefsApi {

    private val prefs by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override fun addTask(task: TaskEntity) {
        val json = gson.toJson(task)
        prefs.edit {
            putString(TASKS_KEY, json)
        }
    }

    override fun getAllTasks(): List<TaskEntity> {
        val json = prefs.getString(TASKS_KEY, null)
        return json?.let {
            gson.fromJson(json, taskEntityListType)
        } ?: emptyList()
    }

    override fun updateTask(uuid: String, task: TaskEntity) {
        TODO("Not yet implemented")
    }
}