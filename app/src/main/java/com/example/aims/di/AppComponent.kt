package com.example.aims.di

import com.example.aims.authorization_imp.di.AuthorizationComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun authorizationComponentFactory(): AuthorizationComponent.Factory
}
