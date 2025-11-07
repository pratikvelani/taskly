package com.pratikvelani.taskly.domain.model

data class Task (
    val uuid: String,
    val title: String,
    val status: String,
    val timestamp: Int,
)