package com.rammu.todo.source

import com.rammu.todo.data.models.LoginRequest
import com.rammu.todo.data.models.LoginResponse
import com.rammu.todo.room.dao.UsersDao
import javax.inject.Inject
import com.rammu.todo.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class LocalDataSource @Inject constructor( val usersDao: UsersDao) {

    fun login(loginRequest: LoginRequest): LoginResponse? =
        usersDao.getUserByCredentials(loginRequest.userMobile, loginRequest.userPassword)

}

