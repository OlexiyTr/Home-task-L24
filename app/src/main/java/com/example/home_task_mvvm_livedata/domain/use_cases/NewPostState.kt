package com.example.home_task_mvvm_livedata.domain.use_cases

sealed class NewPostState{
    object ValidPost : NewPostState()
    data class InvalidPost(
        val titleErrors: List<String>,
        val bodyErrors: List<String>
    ) : NewPostState()
}