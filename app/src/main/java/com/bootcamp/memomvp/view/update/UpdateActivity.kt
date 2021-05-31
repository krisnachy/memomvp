package com.bootcamp.memomvp.view.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.bootcamp.memomvp.R
import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.data.source.TaskRepository
import com.bootcamp.memomvp.data.source.TaskRepositoryInterface
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity(), UpdateView {
    lateinit var taskRepositoryInterface: TaskRepositoryInterface
    lateinit var updatePresenter: UpdatePresenter

    val data : TaskEntity? by lazy {
        intent.getParcelableExtra<TaskEntity>("Update")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        taskRepositoryInterface = TaskRepository(this)
        updatePresenter = UpdatePresenterImplement(this, taskRepositoryInterface)

        //Mendapatkan nilai data yang akan di update
        data?.let {
            edtxtUpdateTitle.setText(it.title)
            edtxUpdateDesc.setText(it.description)
        }

        setSupportActionBar(toolbarEdit)
    }

    override fun onSuccessUpdate(result: String) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.item_task, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menuSave -> {
                val title = edtxtUpdateTitle.text.toString()
                val desc = edtxUpdateDesc.text.toString()

                updatePresenter.updateTask(TaskEntity(data?.id, title, desc))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}