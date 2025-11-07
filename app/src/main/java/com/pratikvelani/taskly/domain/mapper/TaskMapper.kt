package com.pratikvelani.taskly.domain.mapper

import com.pratikvelani.taskly.data.model.TaskEntity
import com.pratikvelani.taskly.domain.model.Task

fun TaskEntity.toDomain(): Task = Task(
    uuid = uuid ?: "",
    title = title ?: "",
    status = status ?: "",
    timestamp = timestamp ?: 0,
)