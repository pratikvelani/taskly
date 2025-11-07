package com.pratikvelani.taskly.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratikvelani.taskly.domain.model.Task
import com.pratikvelani.taskly.domain.usecase.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
): ViewModel(){

    private val _state = MutableStateFlow(
        InternalState(
            isLoading = true,
        )
    )

    internal val state: StateFlow<UiState> =
        combine(
            _state,
            getAllTasksUseCase(Unit),
        ) { internal, tasksResult ->
            val tasks = tasksResult.getOrNull()

            tasks?.let {
                UiState(
                    isLoading = false,
                    tasks = tasks,
                    newTaskTitle = internal.newTaskTitle
                )
            } ?: UiState(
                isLoading = false,
                error = tasksResult.exceptionOrNull()?.message,
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = UiState(
                isLoading = true
            )
        )

    internal fun onNewTaskTitleChange(newText: String) {
        _state.update {
            it.copy(newTaskTitle = newText)
        }
    }

    internal fun onAddTaskClick() {

    }

    data class InternalState(
        val isLoading: Boolean,
        val tasks: List<Task>? = null,
        val newTaskTitle: String = "",
    )

    data class UiState(
        val isLoading: Boolean = false,
        val error: String? = null,
        val tasks: List<Task>? = null,
        val newTaskTitle: String = "",
    )

}