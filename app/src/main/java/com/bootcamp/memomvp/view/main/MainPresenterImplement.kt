package com.bootcamp.memomvp.view.main

import com.bootcamp.memomvp.data.source.TaskRepositoryInterface

class MainPresenterImplement (private val mainView: MainView, private val taskRepositoryInterface: TaskRepositoryInterface) : MainPresenter {
    override fun getAllData() {
        val result = taskRepositoryInterface.getAlldata()

        mainView.getAllData(result)

    }
}