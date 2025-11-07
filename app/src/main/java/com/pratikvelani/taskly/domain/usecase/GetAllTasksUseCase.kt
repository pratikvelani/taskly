package com.pratikvelani.taskly.domain.usecase

import com.pratikvelani.taskly.data.repository.TaskRepository
import com.pratikvelani.taskly.domain.base.ResultUseCase
import com.pratikvelani.taskly.domain.base.mapCatchingResultList
import com.pratikvelani.taskly.domain.mapper.toDomain
import com.pratikvelani.taskly.domain.model.Task
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository,
): ResultUseCase<Unit, Result<List<Task>>>() {

    override suspend fun doWork(params: Unit): Result<List<Task>> =
        taskRepository.getAllTasks().mapCatchingResultList {
            it.toDomain()
        }
}