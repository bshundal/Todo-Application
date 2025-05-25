package com.rammu.todo.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rammu.todo.data.repository.TodoAppRepository
import com.rammu.todo.validations.usecase.ValidateMobileNumberUseCase
import com.rammu.todo.validations.usecase.ValidatePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject
constructor(private val validateMobileNumberUseCase: ValidateMobileNumberUseCase,
            private val validatePasswordUseCase: ValidatePasswordUseCase,
            private val todoAppRepository: TodoAppRepository): ViewModel() {
    val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()


    var userName by mutableStateOf("")
    var userPassword by mutableStateOf("")

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
                val test= todoAppRepository.userLogin(userMobileNo=ui.userMobileNo,userPassword=ui.userPassword)
                }else{

                }

            }
        }
    }


}