package com.example.home_task_l24_archit.Utils

import com.example.home_task_l24_archit.DataLayer.PostData
import retrofit2.Call
import retrofit2.http.GET

interface PostAPIService {
    @GET("/posts")
    fun getPostsFromAPI(): Call<List<PostData>>
}