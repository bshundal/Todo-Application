package com.rammu.todo.presentation.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rammu.todo.data.models.LoginRequest
import com.rammu.todo.data.models.LoginResponse
import com.rammu.todo.domain.usecase.LoginUseCase
import com.rammu.todo.utils.Result
import com.rammu.todo.validations.usecase.ValidateMobileNumberUseCase
import com.rammu.todo.validations.usecase.ValidatePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject
constructor(private val validateMobileNumberUseCase: ValidateMobileNumberUseCase,
            private val validatePasswordUseCase: ValidatePasswordUseCase,
            private val loginUseCase: LoginUseCase): ViewModel() {
    val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()



    fun onFormEvent(loginEvents: LoginEvents) {
        when (loginEvents) {
            is LoginEvents.OnMobileChange -> doMobileChange(loginEvents.value)
            is LoginEvents.OnPasswordChange -> doPasswordChange(loginEvents.value)
            is LoginEvents.OnSubmit -> doLogin()
        }
    }

    private fun doMobileChange(username: String) {
        val result= validateMobileNumberUseCase(username)
        _uiState.update { it.copy(userMobileNo = username, userMobileNoError = !result.isValid,
            userMobileNoErrorMag = result.errorMessage) }
    }

    private fun doPasswordChange(password: String) {
        val result= validatePasswordUseCase(password)
        _uiState.update { it.copy(userPassword = password,userPasswordError = !result.isValid,
            userPasswordErrorMsg = result.errorMessage) }
    }

    private fun doLogin(){
        viewModelScope.launch {
            uiState.value.let {ui->
                if(!ui.userMobileNoError && !ui.userPasswordError){
               val result=  loginUseCase(bindLoginRequest(ui))
                    result.flowOn(Dispatchers.IO).onStart {
                        updateUiState(Result.Loading)
                    }.catch { e->
                        updateUiState(Result.Error(e.message.toString()))
                    }.collect { response->
                        when(response){
                           is Result.Success->  updateUiState(Result.Success(response.data))
                            is Result.Error ->  updateUiState(Result.Error(response.errorMessage))
                            Result.Loading ->  updateUiState(Result.Loading)
                        }

                    }

                }else{
                    updateUiState(Result.Error("Wrong"))
                }

            }
        }
    }

    private fun bindLoginRequest(loginUiState: LoginUiState): LoginRequest{
        return LoginRequest(userMobile=loginUiState.userMobileNo,userPassword=loginUiState.userPassword)
    }

    private fun updateUiState(state: Result<LoginResponse?>) {
        _uiState.update {
            it.copy(dbResult = state)
        }
    }


}