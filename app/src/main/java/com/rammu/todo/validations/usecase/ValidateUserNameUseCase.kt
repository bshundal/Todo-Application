package com.rammu.todo.validations.usecase

import com.rammu.todo.R
import com.rammu.todo.utils.StringResourceProvider
import com.rammu.todo.validations.ValidationResult
import jakarta.inject.Inject


class ValidateUserNameUseCase @Inject constructor(private val stringResourceProvider: StringResourceProvider) {
    operator fun invoke(userNae: String): ValidationResult {
        if (userNae.isBlank()) {
            return ValidationResult(isValid = false, errorMessage = stringResourceProvider.getString(R.string.username_empty_error_msg))
        }
        return ValidationResult(isValid = true)
    }
}