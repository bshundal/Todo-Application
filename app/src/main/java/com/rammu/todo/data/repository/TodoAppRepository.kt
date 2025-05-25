package com.rammu.todo.data.repository

import com.rammu.todo.room.dao.UsersDao
import com.rammu.todo.room.tables.Users
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoAppRepository @Inject constructor(private val usersDao: UsersDao){

    suspend fun insertUser(users: Users)=usersDao.insertUser(users)

    suspend fun userLogin(userMobileNo: String,userPassword: String): Users{
        return usersDao.getUserByCredentials(userMobileNo=userMobileNo,userPassword=userPassword)
    }
}