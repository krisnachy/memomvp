package com.bootcamp.memomvp.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.memomvp.R
import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.data.source.TaskRepository
import com.bootcamp.memomvp.data.source.TaskRepositoryInterface
import com.bootcamp.memomvp.view.task.TaskActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    lateinit var taskRepositoryInterface : TaskRepositoryInterface
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskRepositoryInterface = TaskRepository(this)
        mainPresenter = MainPresenterImplement(this, taskRepositoryInterface)

        //Menampilkan recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainPresenter.getAllData()

        //Ganti Activity menuju Insert (Task Activity)
        val add : View = add_float
        add.setOnClickListener { view ->
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getAllData(list: List<TaskEntity>?) {
        Log.i("Test", "Data berhaasil ditampilkan ${list.toString()}")

        //Menampilkan recyclerview
        runOnUiThread {
            list?.let {
                val adapter = MainAdapter(it)
                recyclerView.adapter = adapter
            }
        }
    }

    fun onDelete(result: String) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
}