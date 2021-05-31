package com.bootcamp.memomvp.view.update

import com.bootcamp.memomvp.data.model.TaskEntity

interface UpdatePresenter {
    fun updateTask(taskEntity: TaskEntity)
}