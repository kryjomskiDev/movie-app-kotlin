package com.example.movieapp.domain.validation.model.validators

import android.util.Patterns.*
import com.example.movieapp.domain.validation.model.TextFieldValidator
import com.example.movieapp.domain.validation.model.ValidationError

class EmailValidator : TextFieldValidator {

    override fun validate(value: String): ValidationError? {
        if (value.isEmpty()){
            return ValidationError.Empty
        } else if (!EMAIL_ADDRESS.matcher(value).matches()){
            return ValidationError.InvalidEmail
        }

        return null
    }
}