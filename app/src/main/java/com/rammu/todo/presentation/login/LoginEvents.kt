package com.rammu.todo.presentation.login

sealed class LoginEvents {
    data class OnMobileChange(val value: String):LoginEvents()
    data class OnPasswordChange(val value: String):LoginEvents()
    data object OnSubmit: LoginEvents()
}