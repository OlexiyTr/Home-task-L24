package com.example.home_task_l24_archit.PresenterLayer

import androidx.annotation.ColorInt

sealed class PostUiModel {

    data class StandardPost(
        val userId: String,
        val title: String,
        val body: String,
        val hasWarning: Boolean,
        @ColorInt
        val textColor: Int,
        @ColorInt
        val backgroundColor: Int
    ) : PostUiModel()

    data class BannedPost(
        val warningText: String,
        @ColorInt
        val backgroundColor: Int,
        @ColorInt
        val textColor: Int
    ) : PostUiModel()
}