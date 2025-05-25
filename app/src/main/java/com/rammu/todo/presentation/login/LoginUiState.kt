package com.rammu.todo.presentation.login

data class LoginUiState(
    val userMobileNo: String=String(),
    val userPassword: String=String(),
    val userMobileNoError: Boolean=false,
    val userPasswordError: Boolean=false,
    val userMobileNoErrorMag: String=String(),
    val userPasswordErrorMsg: String=String())