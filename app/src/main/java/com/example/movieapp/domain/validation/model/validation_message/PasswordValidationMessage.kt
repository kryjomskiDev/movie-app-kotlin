package com.example.movieapp.domain.validation.model.validation_message

import com.example.movieapp.R
import com.example.movieapp.domain.validation.model.ValidationError
import com.example.movieapp.domain.validation.model.ValidationMessage

class PasswordValidationMessage : ValidationMessage {
    override fun getMessage(validationError: ValidationError): Int? {
        return when (validationError) {
            ValidationError.Empty -> R.string.validation_password_field_required
            ValidationError.InvalidPassword -> R.string.validation_invalid_password
            else -> null
        }
    }
}