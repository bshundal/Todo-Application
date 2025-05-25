package com.rammu.todo.room.db

import androidx.room.Database

import androidx.room.RoomDatabase
import com.rammu.todo.room.dao.UsersDao
import com.rammu.todo.room.tables.Users


@Database(entities =[Users::class], version = 1, exportSchema = false)
abstract  class TodoAppDb: RoomDatabase() {
    abstract fun userDao(): UsersDao
}