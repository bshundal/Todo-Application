package com.rammu.todo.presentation.login

import com.rammu.todo.data.models.LoginResponse
import com.rammu.todo.utils.Result

data class LoginUiState(
    val userMobileNo: String="9644079449",
    val userPassword: String="12345",
    val userMobileNoError: Boolean=false,
    val userPasswordError: Boolean=false,
    val userMobileNoErrorMag: String=String(),
    val userPasswordErrorMsg: String=String(),
    val dbResult: Result<LoginResponse?>?=null
)