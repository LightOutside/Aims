package com.example.aims.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aims.authorization_imp.di.AuthorizationComponent

class AuthorizationViewModelFactory(
    private val authorizationComponent: AuthorizationComponent
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return authorizationComponent.authorizationViewModel() as T
    }
}
