package com.example.home_task_l24_archit.DomainLayer

import com.example.home_task_l24_archit.DataLayer.PostData
import com.example.home_task_l24_archit.Shared.Errors
import com.example.home_task_l24_archit.DataLayer.UserDataRepository
import com.example.home_task_l24_archit.Shared.Result

class PostModelMapper {
    fun map(dataResult: Result<List<PostData>, Errors>): Result<List<PostModel>, Errors> {
        val blackList = UserDataRepository().getBlackList()
        return dataResult.mapSuccess { posts ->
            posts.map { post ->
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