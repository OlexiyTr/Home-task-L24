package com.example.home_task_l24_archit.DomainLayer

data class PostModel(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
    val userState: UserState
)