package com.example.home_task_mvvm_livedata

import android.app.Application
import com.example.home_task_mvvm_livedata.di.AppComponent
import com.example.home_task_mvvm_livedata.di.AppModule
import com.example.home_task_mvvm_livedata.di.DaggerAppComponent

class AppApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
}}

