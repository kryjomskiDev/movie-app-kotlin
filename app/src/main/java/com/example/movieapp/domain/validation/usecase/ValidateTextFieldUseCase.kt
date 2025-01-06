package com.example.movieapp.domain.validation.usecase

import com.example.movieapp.domain.validation.FailedValidation
import com.example.movieapp.domain.validation.model.TextFieldValidator

class ValidateTextFieldUseCase {

    operator fun invoke(value: String, validators: List<TextFieldValidator>) : FailedValidation? {
         validators.forEach {
             val error = it.validate(value) ?: return null

             return FailedValidation(error = error)
         }

        return null
    }
}