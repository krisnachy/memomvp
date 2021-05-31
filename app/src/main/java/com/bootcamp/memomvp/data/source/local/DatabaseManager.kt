package com.bootcamp.memomvp.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.memomvp.data.model.TaskEntity
import com.bootcamp.memomvp.data.source.local.dao.TaskDao


@Database(entities = [TaskEntity::class],version = 1)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object{
        private var INSTANCE  : DatabaseManager? = null

        fun getInstance(context: Context) : DatabaseManager? {
            if (INSTANCE == null){
                synchronized(DatabaseManager::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    DatabaseManager::class.java,"Task.db")
                    .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}