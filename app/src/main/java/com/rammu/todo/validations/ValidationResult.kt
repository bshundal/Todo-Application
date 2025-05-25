package com.rammu.todo.validations

data class ValidationResult(
    val isValid: Boolean,
    val errorMessage: String = String()
)