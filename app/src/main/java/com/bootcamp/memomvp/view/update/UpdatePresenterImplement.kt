package com.bootcamp.memomvp.view.update

import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.data.source.TaskRepositoryInterface

class UpdatePresenterImplement (private val updateView: UpdateView,
                                private val taskRepositoryInterface: TaskRepositoryInterface) : UpdatePresenter
{
    override fun updateTask(taskEntity: TaskEntity) {
        val result = taskRepositoryInterface.updateTask(taskEntity)

        if (result != 0) {
            updateView.onSuccessUpdate("Success Update Data")
        } else {
            updateView.onSuccessUpdate("Failed to Update Data")
        }
    }
}