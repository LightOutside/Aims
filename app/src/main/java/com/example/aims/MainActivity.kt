package com.example.aims

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aims.authorization_imp.presentation.AuthorizationScreen
import com.example.aims.authorization_imp.presentation.AuthorizationViewModel
import com.example.aims.di.AuthorizationViewModelFactory
import com.example.aims.ui.theme.AimsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as AimsApplication).appComponent
        val authorizationComponent = appComponent.authorizationComponentFactory().create()
        val factory = AuthorizationViewModelFactory(authorizationComponent)

        enableEdgeToEdge()
        setContent {
            AimsTheme {
                val viewModel: AuthorizationViewModel = viewModel(factory = factory)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AuthorizationScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
