package com.rammu.todo.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rammu.todo.data.repository.UsersRepository
import com.rammu.todo.room.tables.Users
import com.rammu.todo.validations.usecase.ValidateEmailUseCase
import com.rammu.todo.validations.usecase.ValidateMobileNumberUseCase
import com.rammu.todo.validations.usecase.ValidatePasswordUseCase
import com.rammu.todo.validations.usecase.ValidateUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val validateUserNameUseCase: ValidateUserNameUseCase,
    private val validateMobileNumberUseCase: ValidateMobileNumberUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val usersRepository: UsersRepository
) : ViewModel() {
    val _uiState = MutableStateFlow(RegistrationUiState())
    val uiState: StateFlow<RegistrationUiState> = _uiState.asStateFlow()



    fun onFormEvent(registrationFormEvents: RegistrationFormEvents) {
        when (registrationFormEvents) {
            is RegistrationFormEvents.OnUserNameChange -> doUserNameChange(registrationFormEvents.value)
            is RegistrationFormEvents.OnMobileNoChange -> doMobileNoChange(registrationFormEvents.value)
            is RegistrationFormEvents.OnEmailChange -> doEmailChange(registrationFormEvents.value)
            is RegistrationFormEvents.OnPasswordChange -> doPasswordChange(registrationFormEvents.value)
            is RegistrationFormEvents.OnSubmit -> doRegistration()
        }
    }


    private fun doUserNameChange(username: String) {
      val result= validateUserNameUseCase(username)
        _uiState.update { it.copy(userName = username, userNameError = !result.isValid,
            userNameErrorMsg = result.errorMessage) }
    }

    private fun doMobileNoChange(mobile: String) {
        val result= validateMobileNumberUseCase(mobile)
        _uiState.update { it.copy(userMobileNo = mobile,userMobileNoError = !result.isValid,
            userMobileNoErrorMsg = result.errorMessage) }
    }


    private fun doEmailChange(email: String) {
        val result= validateEmailUseCase(email)
        _uiState.update { it.copy(userEmail = email,userEmailError = !result.isValid,
            userEmailErrorMsg = result.errorMessage) }
    }

    private fun doPasswordChange(password: String) {
        val result= validatePasswordUseCase(password)
        _uiState.update { it.copy(userPassword = password,userPasswordError = !result.isValid,
            userPasswordErrorMsg = result.errorMessage) }
    }


    private fun doRegistration(){
        viewModelScope.launch {
            uiState.value.let {ui->
                if(!ui.userNameError && !ui.userMobileNoError && !ui.userEmailError && !ui.userPasswordError){
                    usersRepository.insertUser(bindUserRequest(ui))
                }else{

                }

            }
        }

    }

    private fun bindUserRequest(registrationUiState: RegistrationUiState): Users{
        return Users(userName = registrationUiState.userName, userEmailId = registrationUiState.userEmail, userMobileNo = registrationUiState.userMobileNo, userPassword = registrationUiState.userPassword)
    }
}