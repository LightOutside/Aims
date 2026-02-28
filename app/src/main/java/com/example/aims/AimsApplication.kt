package com.example.aims

import android.app.Application
import com.example.aims.di.AppComponent
import com.example.aims.di.DaggerAppComponent

class AimsApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}
