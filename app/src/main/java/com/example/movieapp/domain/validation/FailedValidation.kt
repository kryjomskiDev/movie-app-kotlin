package com.example.movieapp.domain.validation

import com.example.movieapp.domain.validation.model.ValidationError
import com.example.movieapp.domain.validation.model.ValidationMessage

class FailedValidation(
    val error: ValidationError,
    val message: Int? = null
) {

    fun validationMessage(validationMessages: List<ValidationMessage>) : Int? {
        for (validationMessage in validationMessages) {
            val message = validationMessage.getMessage(error)

            if (message != null) {
                return message
            }
        }

        return null
    }
}