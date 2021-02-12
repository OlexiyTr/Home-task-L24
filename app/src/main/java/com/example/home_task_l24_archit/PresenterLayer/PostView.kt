package com.example.home_task_l24_archit.PresenterLayer


interface PostView {
    fun showPosts(post: List<PostUiModel>)
    fun showError(error: String)
}