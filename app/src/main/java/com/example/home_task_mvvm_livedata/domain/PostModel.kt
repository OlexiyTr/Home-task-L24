package com.example.home_task_mvvm_livedata.domain

import java.io.Serializable

data class PostModel(
    val id: Int?,
    val userId: Int?,
    val title: String?,
    val body: String?,
    val userState: UserState
) : Serializable