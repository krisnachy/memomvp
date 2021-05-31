package com.bootcamp.memomvp.data.source

import android.content.Context
import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.data.source.local.DatabaseManager

class TaskRepository(context: Context) : TaskRepositoryInterface {

    private var mDatabaseManager : DatabaseManager? =null
    init {
        mDatabaseManager = DatabaseManager.getInstance(context)
    }

    override fun insertTask(taskEntity: TaskEntity): Long? {
       return  mDatabaseManager?.taskDao()?.insertTask(taskEntity)
    }

    override fun getAlldata(): List<TaskEntity>? {
        return mDatabaseManager?.taskDao()?.getAllData()
    }

    override fun updateTask(taskEntity: TaskEntity): Int? {
        return mDatabaseManager?.taskDao()?.updateTask(taskEntity)
    }
}