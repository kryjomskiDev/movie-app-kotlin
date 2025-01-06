package com.example.movieapp.domain.validation.model

interface TextFieldValidator {
    fun validate(value: String) : ValidationError?
}