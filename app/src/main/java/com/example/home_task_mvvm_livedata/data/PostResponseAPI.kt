package com.example.home_task_mvvm_livedata.data

import retrofit2.Call
import retrofit2.http.GET

interface PostResponseAPI {
    @GET("/posts")
    fun getPostsFromAPI(): Call<List<PostResponse>>
}