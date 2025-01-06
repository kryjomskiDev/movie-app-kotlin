package com.example.movieapp.domain.validation.model

interface ValidationMessage {
    fun getMessage(validationError: ValidationError) :  Int?
}