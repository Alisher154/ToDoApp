package uz.texnopos.mytodoapp.data.repository

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import uz.texnopos.mytodoapp.data.ToDoDao
import uz.texnopos.mytodoapp.data.models.ToDoTask
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()

    fun getSelectedTask(taskId: Int) = toDoDao.getSelectedTask(taskId)

    suspend fun addTask(toDoTask: ToDoTask) = toDoDao.addTask(toDoTask)
    suspend fun updateTask(toDoTask: ToDoTask) = toDoDao.updateTask(toDoTask)
    suspend fun deleteTask(toDoTask: ToDoTask) = toDoDao.deleteTask(toDoTask)
    suspend fun deleteAllTasks() = toDoDao.deleteAllTask()

    fun searchDatabase(searchQuery: String) = toDoDao.searchDatabase(searchQuery)

}