package com.rammu.todo.presentation.registration

data class RegistrationUiState(
    val userName: String=String(),
    val userMobileNo: String=String(),
    val userEmail: String=String(),
    val userPassword: String=String(),
    val userNameError: Boolean=false,
    val userMobileNoError: Boolean=false,
    val userEmailError: Boolean=false,
    val userPasswordError: Boolean=false,
    val userNameErrorMsg: String=String(),
    val userMobileNoErrorMsg: String=String(),
    val userEmailErrorMsg: String=String(),
    val userPasswordErrorMsg: String=String(),

)
