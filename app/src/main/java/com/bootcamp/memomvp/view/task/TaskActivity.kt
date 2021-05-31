package com.bootcamp.memomvp.view.task

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bootcamp.memomvp.R
import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.data.source.TaskRepository
import com.bootcamp.memomvp.data.source.TaskRepositoryInterface
import kotlinx.android.synthetic.main.activity_task.*

class TaskActivity : AppCompatActivity(),TaskView {
    lateinit var taskRepositoryInterface : TaskRepositoryInterface
    lateinit var taskPresenter: TaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        taskRepositoryInterface = TaskRepository(this)
        taskPresenter = TaskPresenterImplement(this,taskRepositoryInterface)
        setSupportActionBar(toolbar)
    }


    override fun onSuccessInsert(result: String) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        edtxtTaskTitle.setText("")
        edtxDescription.setText("")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.item_task,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId){
            R.id.menuSave ->{
                val title = edtxtTaskTitle.text.toString()
                val description = edtxDescription.text.toString()
                taskPresenter.insertTask(TaskEntity(null,title,description))
                true
            }
            else ->  return super.onOptionsItemSelected(item)
        }

    }

}