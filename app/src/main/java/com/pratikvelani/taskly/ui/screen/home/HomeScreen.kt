package com.pratikvelani.taskly.ui.screen.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen (
    viewModel: HomeViewModel,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Text("Hello, Home Screen")

    LazyColumn(
        modifier = Modifier
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextField(
                    modifier = Modifier.weight(1f, fill = true),
                    value = state.newTaskTitle, // The current value displayed in the TextField
                    onValueChange = { newText ->
                        viewModel.onNewTaskTitleChange(newText)
                    },
                    label = { Text("Enter your name") } // Optional label for the TextField
                )
                Button(
                    onClick = {
                        viewModel.onAddTaskClick()
                    }
                ) {
                    Text("Add")
                }
            }
        }
        state.tasks?.let { tasks ->
            items (tasks) { task ->
                Text (task.title)
            }
        }
    }
}
