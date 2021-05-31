package com.bootcamp.memomvp.view.main

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.memomvp.R
import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.view.update.UpdateActivity
import kotlinx.android.synthetic.main.list_main_activity.view.*

class MainAdapter(val listTask : List<TaskEntity>) : RecyclerView.Adapter<MainAdapter.ListTaskViewHolder>() {
    inner class ListTaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.tv_title
        val desc = view.tv_desc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListTaskViewHolder {
        return ListTaskViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_main_activity, parent, false))
    }

    override fun onBindViewHolder(holder: ListTaskViewHolder, position: Int) {

        listTask.get(position).let {
            holder.title.text = it.title
            holder.desc.text = it.description
        }

        holder.itemView.iv_edit.setOnClickListener {
            val intentEdt = Intent(it.context, UpdateActivity::class.java)

            intentEdt.putExtra("Task", listTask[position])
            it.context.startActivity(intentEdt)
        }

        holder.itemView.iv_delete.setOnClickListener {
            AlertDialog.Builder(it.context).setPositiveButton("Ya") {p0, p1 ->

            }
        }
    }

    override fun getItemCount(): Int {
        return listTask.size
    }
}