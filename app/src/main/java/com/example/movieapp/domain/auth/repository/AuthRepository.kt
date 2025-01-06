package com.example.movieapp.domain.auth.repository

interface AuthRepository {
    suspend fun createAccount(email: String, password: String)

    suspend fun login(email: String, password: String)

    fun logout()

    fun isUserSignedIn() : Boolean

    fun getCurrentUserEmail() : String?
}