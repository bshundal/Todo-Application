package com.rammu.todo.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class RegistrationRequest(
    @PrimaryKey(autoGenerate = true)
    val userId:Int,
    val userName: String,
    val userMobileNo: String,
    val userEmailId: String,
    val userPassword: String)
