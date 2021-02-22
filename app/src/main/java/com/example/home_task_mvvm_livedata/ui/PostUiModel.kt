package com.example.home_task_mvvm_livedata.ui

sealed class PostUiModel(val id: Int?, val userId: Int?) {

    class StandardPost(
        id: Int?,
        userId: Int?,
        val title: String?,
        val body: String?,
        val hasWarning: Boolean,
    ) : PostUiModel(id, userId)

    class BannedPost(
        id: Int?,
        userId: Int?,
        val warningText: String?,

        ) : PostUiModel(id, userId)
}