package com.example.aims.di

import com.example.aims.authorization_imp.di.AuthorizationComponent
import dagger.Module

@Module(subcomponents = [AuthorizationComponent::class])
object AppModule
