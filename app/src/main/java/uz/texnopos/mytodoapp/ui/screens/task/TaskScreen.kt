package uz.texnopos.mytodoapp.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import uz.texnopos.mytodoapp.data.models.ToDoTask
import uz.texnopos.mytodoapp.util.Action

@Composable
fun TaskScreen(
    selectedTask:ToDoTask?,
    navigateToListScreen: (Action) -> Unit,
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {

        })
}