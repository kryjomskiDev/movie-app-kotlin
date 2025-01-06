package com.example.movieapp.utils

import com.example.movieapp.domain.validation.FailedValidation
import com.example.movieapp.domain.validation.model.validation_message.EmailValidationMessage
import com.example.movieapp.domain.validation.model.validation_message.PasswordValidationMessage

fun getEmailErrorMessage(failedValidation: FailedValidation?): Int? =
    failedValidation?.validationMessage(listOf(EmailValidationMessage()))

fun getPasswordErrorMessage(failedValidation: FailedValidation?): Int? =
    failedValidation?.validationMessage(listOf(PasswordValidationMessage()))