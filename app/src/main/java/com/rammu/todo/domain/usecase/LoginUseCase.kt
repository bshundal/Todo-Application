package com.rammu.todo.domain.usecase

import com.rammu.todo.data.models.LoginRequest
import com.rammu.todo.data.models.LoginResponse
import com.rammu.todo.data.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.rammu.todo.utils.Result

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    operator fun invoke(loginRequest: LoginRequest): Flow<Result<LoginResponse?>>{
         return loginRepository.login(loginRequest)
    }
}