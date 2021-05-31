package com.bootcamp.memomvp.data.source

import com.bootcamp.memomvp.data.model.TaskEntity

interface TaskRepositoryInterface {

    fun insertTask(taskEntity: TaskEntity) : Long?

    fun getAlldata() : List<TaskEntity>?

    fun updateTask(taskEntity: TaskEntity) : Int?
}