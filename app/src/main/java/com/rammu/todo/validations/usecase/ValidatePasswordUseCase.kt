package com.rammu.todo.validations.usecase

import android.content.Context
import androidx.compose.ui.res.stringResource
import com.rammu.todo.R
import com.rammu.todo.utils.StringResourceProvider
import com.rammu.todo.validations.ValidationResult
import jakarta.inject.Inject

class ValidatePasswordUseCase @Inject constructor( private val stringResourceProvider: StringResourceProvider) {
    operator fun invoke(password: String): ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(isValid = false, errorMessage = stringResourceProvider.getString(R.string.password_empty_error_msg))
        }
        if (password.length < 5) {
            return ValidationResult(
                isValid = false,
                errorMessage = stringResourceProvider.getString(R.string.password_length_error_msg)
            )
        }
        return ValidationResult(isValid = true)
    }
}