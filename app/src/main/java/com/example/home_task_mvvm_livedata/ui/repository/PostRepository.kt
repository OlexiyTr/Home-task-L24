package com.example.home_task_mvvm_livedata.ui.repository

import com.example.home_task_mvvm_livedata.data.PostResponse
import com.example.home_task_mvvm_livedata.data.PostResponseAPI
import com.example.home_task_mvvm_livedata.data.PostResponseToPostModelMapper
import com.example.home_task_mvvm_livedata.data.PostResponsesDataBase
import com.example.home_task_mvvm_livedata.domain.PostModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(
    private val database: PostResponsesDataBase,
    private val api: PostResponseAPI,
    private val responseToPostModelMapper: PostResponseToPostModelMapper,

    ) {
    fun getPosts(): List<PostModel>? {
        return if (database.getCachedPosts().isNotEmpty()) {
            responseToPostModelMapper.map(database.getCachedPosts())
        } else {
            val posts = database.updatePostsFromRemote(api.getPostsFromAPI().execute().body())
            return responseToPostModelMapper.map(posts)
        }
    }

    fun addNewPost(post: PostResponse) {
        database.addNewLocalPost(post)
    }
}