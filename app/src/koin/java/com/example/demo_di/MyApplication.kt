package com.example.demo_di

import android.app.Application
import com.example.demo_di.di.appModule
import com.example.demo_di.di.interfaceModule
import com.example.demo_di.di.repoModule
import com.example.demo_di.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule,
                repoModule,
                viewmodelModule,
                interfaceModule
            )
        }
    }
}