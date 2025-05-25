package com.rammu.todo.validations.usecase

import android.util.Patterns
import com.rammu.todo.R
import com.rammu.todo.utils.StringResourceProvider
import com.rammu.todo.validations.ValidationResult
import jakarta.inject.Inject

class ValidateEmailUseCase @Inject constructor(private val stringResourceProvider: StringResourceProvider) {
    operator fun invoke(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(isValid = false, errorMessage = stringResourceProvider.getString(R.string.email_id_empty_error_msg))
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(isValid = false, errorMessage =stringResourceProvider.getString(R.string.email_id_format_error_msg))
        }
        return ValidationResult(isValid = true)
    }
}
