package com.bootcamp.memomvp.view.main

import com.bootcamp.memomvp.data.model.TaskEntity

interface MainView {
    fun getAllData(list: List<TaskEntity>?)
}