package uz.texnopos.mytodoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.texnopos.mytodoapp.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1,exportSchema = false)
abstract class ToDoDatabase:RoomDatabase() {

    abstract fun toDoDao():ToDoDao
}