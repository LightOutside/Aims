package com.example.aims.authorization_imp.di

import com.example.aims.authorization_imp.presentation.AuthorizationViewModel
import dagger.Subcomponent

@AuthorizationScope
@Subcomponent(modules = [AuthorizationModule::class])
interface AuthorizationComponent {

    fun authorizationViewModel(): AuthorizationViewModel

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthorizationComponent
    }
}
