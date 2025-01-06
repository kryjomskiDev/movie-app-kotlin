package com.example.movieapp.data.auth.repository

import com.example.movieapp.domain.auth.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {

    override suspend fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(
            email,
            password
        ).await()
    }

    override suspend fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(
            email,
            password
        ).await()

    }

    override fun logout() = auth.signOut()

    override fun isUserSignedIn(): Boolean = auth.currentUser != null

    override fun getCurrentUserEmail(): String?  = auth.currentUser?.email
}