package com.rammu.todo.room.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val userId:Int?=null,
    val userName: String,
    val userMobileNo: String,
    val userEmailId: String,
    val userPassword: String)
