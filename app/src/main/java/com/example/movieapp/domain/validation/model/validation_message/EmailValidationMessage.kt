package com.example.movieapp.domain.validation.model.validation_message

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.domain.validation.model.ValidationError
import com.example.movieapp.domain.validation.model.ValidationMessage

class EmailValidationMessage : ValidationMessage {

    override fun getMessage(validationError: ValidationError): Int? {
        return when (validationError) {
            ValidationError.Empty -> R.string.validation_email_field_required
            ValidationError.InvalidEmail -> R.string.validation_invalid_email
            else -> null
        }
    }

}