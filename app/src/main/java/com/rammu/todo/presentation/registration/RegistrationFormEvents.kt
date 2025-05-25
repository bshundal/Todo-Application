package com.rammu.todo.presentation.registration

sealed class RegistrationFormEvents {
    data class OnUserNameChange(val value: String): RegistrationFormEvents()
    data class OnMobileNoChange(val value: String): RegistrationFormEvents()
    data class OnEmailChange(val value: String): RegistrationFormEvents()
    data class OnPasswordChange(val value: String): RegistrationFormEvents()
    data class OnSubmit(val onBack:()-> Unit): RegistrationFormEvents()
}