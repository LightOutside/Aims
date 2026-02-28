package com.example.aims.authorization_imp.domain

interface AuthRepository {
    suspend fun login(): Result<Unit>
}
