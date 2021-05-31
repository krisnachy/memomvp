package com.bootcamp.memomvp.view.task

import com.bootcamp.memomvp.data.model.TaskEntity

interface TaskPresenter {
     fun insertTask(taskEntity: TaskEntity)
}