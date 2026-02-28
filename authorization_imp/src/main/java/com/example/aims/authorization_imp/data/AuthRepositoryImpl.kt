package com.example.aims.authorization_imp.data

import com.example.aims.authorization_imp.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override suspend fun login(): Result<Unit> = Result.success(Unit)
}
