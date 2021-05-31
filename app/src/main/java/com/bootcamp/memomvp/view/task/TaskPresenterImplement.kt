package com.bootcamp.memomvp.view.task

import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.data.source.TaskRepositoryInterface

class TaskPresenterImplement(private val taskView: TaskView,
                             private val taskRepositoryInterface: TaskRepositoryInterface) : TaskPresenter
{
    override fun insertTask(taskEntity: TaskEntity) {
        val result  = taskRepositoryInterface.insertTask(taskEntity)

        if (result != 0.toLong()){
            taskView.onSuccessInsert("Success Insert Data")
        }else{
            taskView.onSuccessInsert("Failed Insert Data")
        }
    }

}