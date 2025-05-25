package com.rammu.todo.data.repository

import com.rammu.todo.data.models.LoginRequest
import com.rammu.todo.data.models.LoginResponse
import com.rammu.todo.utils.Result
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(loginRequest: LoginRequest): Flow<Result<LoginResponse?>>
}