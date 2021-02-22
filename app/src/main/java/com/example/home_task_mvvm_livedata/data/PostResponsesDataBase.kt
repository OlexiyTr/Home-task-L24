package com.example.home_task_mvvm_livedata.data

import javax.inject.Singleton

@Singleton
object PostResponsesDataBase {

    private val postResponsesFromNet : MutableList<PostResponse> = mutableListOf()
    private val localPosts : MutableList<PostResponse> = mutableListOf()

    fun updatePostsFromRemote(newList: List<PostResponse>?) :  List<PostResponse>{
        //postResponsesFromNet.clear()
        if (newList != null) {
            postResponsesFromNet.addAll(newList)
        }
        return getCachedPosts()
    }

    fun addNewLocalPost(post: PostResponse) {
        localPosts.add(0, post)
    }

    fun getCachedPosts(): List<PostResponse> {
        return localPosts + postResponsesFromNet
    }
}