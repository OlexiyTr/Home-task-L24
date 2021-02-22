package com.example.home_task_mvvm_livedata.di

import android.content.Context
import com.example.home_task_mvvm_livedata.AppApplication
import com.example.home_task_mvvm_livedata.data.PostResponseAPI
import com.example.home_task_mvvm_livedata.data.PostResponsesDataBase
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule (private val context : Context) {
    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory{
        return GsonConverterFactory.create(
            GsonBuilder().setLenient().create()
        )
    }

    @Provides
    @Singleton
    fun providePostsApi(retrofit: Retrofit): PostResponseAPI {
        return retrofit.create(PostResponseAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(): PostResponsesDataBase = PostResponsesDataBase

}