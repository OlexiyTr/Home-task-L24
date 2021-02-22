package com.example.home_task_mvvm_livedata.data

import com.example.home_task_mvvm_livedata.domain.PostModel
import com.example.home_task_mvvm_livedata.domain.UserState
import com.example.home_task_mvvm_livedata.domain.UserStateConditions
import javax.inject.Inject

class PostResponseToPostModelMapper @Inject constructor(){

    fun map(responses: List<PostResponse>?): List<PostModel>?{
        val blackList = UserStateConditions().getBlackList()
        return responses.let { posts ->
            posts?.map { post ->
                val userState: UserState? = blackList
                    .find{ it.userId == post.userId }
                    ?.userState

                PostModel(
                    id = post.id,
                    userId = post.userId,
                    title = post.title,
                    body = post.body,
                    userState = userState ?: UserState.NORMAL
                )
            }
        }
    }

}