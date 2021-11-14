package uz.texnopos.mytodoapp.navigation

import androidx.navigation.NavController
import uz.texnopos.mytodoapp.util.Action
import uz.texnopos.mytodoapp.util.Constants.TASK_SCREEN

class Screens(navController: NavController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(TASK_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}