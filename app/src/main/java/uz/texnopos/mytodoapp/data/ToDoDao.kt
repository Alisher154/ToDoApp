package uz.texnopos.mytodoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.texnopos.mytodoapp.data.models.ToDoTask

@Dao
interface ToDoDao {

    @Query("select * from todo_table order by id asc")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("select * from todo_table where id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: ToDoTask)

    @Update
    suspend fun updateTask(task: ToDoTask)

    @Delete
    suspend fun deleteTask(task: ToDoTask)

    @Query("delete from todo_table")
    suspend fun deleteAllTask()

    @Query("select *from todo_table where title like :searchQuery or description like :searchQuery")
    fun searchDatabase(searchQuery:String):Flow<List<ToDoTask>>

    @Query("select *from todo_table order by case when priority like 'L%' then 1 when priority like 'M%' then 2 when priority like 'H%' then 3 end")
    fun sortByLowPriority():Flow<List<ToDoTask>>

    @Query("select *from todo_table order by case when priority like 'H%' then 1 when priority like 'M%' then 2 when priority like 'L%' then 3 end")
    fun sortByHighPriority():Flow<List<ToDoTask>>
}