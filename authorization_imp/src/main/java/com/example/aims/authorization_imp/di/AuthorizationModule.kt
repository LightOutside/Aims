package com.example.aims.authorization_imp.di

import com.example.aims.authorization_imp.data.AuthRepositoryImpl
import com.example.aims.authorization_imp.domain.AuthRepository
import dagger.Binds
import dagger.Module

@Module
abstract class AuthorizationModule {

    @Binds
    @AuthorizationScope
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}
