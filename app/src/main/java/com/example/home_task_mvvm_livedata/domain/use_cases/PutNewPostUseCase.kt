package com.example.home_task_mvvm_livedata.domain.use_cases

import com.example.home_task_mvvm_livedata.data.PostResponse
import com.example.home_task_mvvm_livedata.ui.repository.PostRepository
import java.util.*
import javax.inject.Inject

class PutNewPostUseCase @Inject constructor(
    private val postsRepository: PostRepository
) {
    companion object {
        private const val USER_ID = 0
        private const val ID = 1
    }

    fun put(title: String, body: String) {
        val post = PostResponse(
            userId = USER_ID,
            id = ID,
            title = title,
            body = body
        )
        postsRepository.addNewPost(post)
    }
}