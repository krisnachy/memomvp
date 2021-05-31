package com.bootcamp.memomvp.data.source.local.dao

import androidx.room.*
import com.bootcamp.memomvp.data.model.TaskEntity

@Dao
interface TaskDao {

    @Insert
    fun insertTask(taskEntity: TaskEntity) : Long

    @Query("SELECT * FROM TaskEntity")
    fun getAllData() : List<TaskEntity>

    @Update
    fun updateTask(taskEntity: TaskEntity) : Int

    @Delete
    fun deleteTask(taskEntity: TaskEntity) : Int
}