package com.example.movieapp.domain.validation.model.validators

import com.example.movieapp.domain.validation.model.TextFieldValidator
import com.example.movieapp.domain.validation.model.ValidationError

class PasswordValidator : TextFieldValidator {

    override fun validate(value: String): ValidationError? {
        if (value.isEmpty()){
            return ValidationError.Empty
        } else if (value.length < 8) {
            return ValidationError.InvalidPassword
        }

        return null
    }
}