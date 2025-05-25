package com.rammu.todo.validations.usecase
import com.rammu.todo.R
import com.rammu.todo.utils.StringResourceProvider
import com.rammu.todo.validations.ValidationResult
import javax.inject.Inject // If you're using Dagger Hilt

class ValidateMobileNumberUseCase @Inject constructor(private val stringResourceProvider: StringResourceProvider) {
    operator fun invoke(mobileNumber: String): ValidationResult {
        if (mobileNumber.isBlank()) {
            return ValidationResult(
                isValid = false,
                errorMessage = stringResourceProvider.getString(R.string.mobile_number_empty_error_msg)
            )
        }

        val cleanedNumber = mobileNumber.filter { it.isDigit() }

        if (cleanedNumber.length != 10) {
            return ValidationResult(
                isValid = false,
                errorMessage =stringResourceProvider.getString(R.string.mobile_number_length_error_msg)
            )
        }

        // 2. Must start with 6, 7, 8, or 9
        // This is a common rule for Indian mobile numbers
        if (!cleanedNumber.startsWith("6") &&
            !cleanedNumber.startsWith("7") &&
            !cleanedNumber.startsWith("8") &&
            !cleanedNumber.startsWith("9")) {
            return ValidationResult(
                isValid = false,
                errorMessage = stringResourceProvider.getString(R.string.mobile_number_format_error_msg)
            )
        }

        // Optional: More advanced regex for specific patterns, e.g., if you need to validate country codes
        // For simplicity, we'll stick to a 10-digit Indian number here.
        // val mobileNumberPattern = "^[6-9]\\d{9}$".toRegex()
        // if (!mobileNumberPattern.matches(cleanedNumber)) {
        //     return ValidationResult(
        //         isValid = false,
        //         errorMessage = "Invalid mobile number format."
        //     )
        // }

        return ValidationResult(isValid = true)
    }
}