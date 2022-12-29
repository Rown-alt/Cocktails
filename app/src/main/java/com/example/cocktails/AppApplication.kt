package com.example.cocktails

import android.app.Application
import com.example.cocktails.di.appModule
import com.example.domain.api.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@AppApplication)
            modules(listOf(appModule, domainModule))
        }
    }
}