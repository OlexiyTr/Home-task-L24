package com.example.home_task_mvvm_livedata.di

import com.example.home_task_mvvm_livedata.InputNewPostActivity
import com.example.home_task_mvvm_livedata.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: InputNewPostActivity)
}
