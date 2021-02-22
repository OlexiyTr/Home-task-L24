package com.example.home_task_mvvm_livedata.domain.use_cases

import com.example.home_task_mvvm_livedata.domain.PostModelToPostUiMapper
import com.example.home_task_mvvm_livedata.ui.PostUiModel
import com.example.home_task_mvvm_livedata.ui.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository,
    private val postModelToPostUiMapper: PostModelToPostUiMapper
) {

    fun execute(): List<PostUiModel>? {
        return postModelToPostUiMapper.map(repository.getPosts())
    }
}