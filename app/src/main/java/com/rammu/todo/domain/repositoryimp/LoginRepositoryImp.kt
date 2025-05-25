package com.rammu.todo.domain.repositoryimp

import com.rammu.todo.data.models.LoginRequest
import com.rammu.todo.data.models.LoginResponse
import com.rammu.todo.data.repository.LoginRepository
import com.rammu.todo.source.LocalDataSource
import com.rammu.todo.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class LoginRepositoryImp(val localDataSource: LocalDataSource): LoginRepository {
    override  fun login(loginRequest: LoginRequest): Flow<Result<LoginResponse?>> = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(data=localDataSource.login(loginRequest)))
        }
        catch (e: Exception){
            Result.Error(e.message.toString())
    }

    }



    }

