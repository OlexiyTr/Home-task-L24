package com.example.home_task_mvvm_livedata.domain


import com.example.home_task_mvvm_livedata.ui.PostUiModel.StandardPost
import com.example.home_task_mvvm_livedata.ui.PostUiModel.BannedPost
import com.example.home_task_mvvm_livedata.ui.PostUiModel
import javax.inject.Inject

class PostModelToPostUiMapper @Inject constructor(
) {
    fun map(models: List<PostModel>?): List<PostUiModel>? {
        return models.let {
            models?.map { postModel ->
                when (postModel.userState) {
                    UserState.NORMAL -> setupNormalPost(postModel, false)
                    UserState.HAS_WARNING -> setupNormalPost(postModel, true)
                    UserState.BANNED -> setupBannedPost(postModel)
                }
            }
        }
    }

    private fun setupNormalPost(postModel: PostModel, hasWarning: Boolean): StandardPost {
        return StandardPost(
            id = postModel.id,
            userId = postModel.userId,
            title = postModel.title,
            body = postModel.body,
            hasWarning = hasWarning,
        )
    }

    private fun setupBannedPost(postModel: PostModel): BannedPost {
        return BannedPost(
            id = postModel.id,
            userId = postModel.userId,
            warningText = "Тут міг бути пост юзера ${postModel.userId.toString()}, але він забанений"
        )
    }

}