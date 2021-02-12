package com.example.home_task_l24_archit.PresenterLayer

import com.example.home_task_l24_archit.DomainLayer.PostModel
import com.example.home_task_l24_archit.DomainLayer.UserState
import com.example.home_task_l24_archit.R
import com.example.home_task_l24_archit.Shared.Errors
import com.example.home_task_l24_archit.Utils.ResourceRepository
import com.example.home_task_l24_archit.Shared.Result
import com.example.home_task_l24_archit.PresenterLayer.PostUiModel.StandardPost
import com.example.home_task_l24_archit.PresenterLayer.PostUiModel.BannedPost

class PostUiMapper(private val resourceRepository: ResourceRepository) {
    fun map(result: Result<List<PostModel>, Errors>): Result<List<PostUiModel>, String> {
        return result.mapSuccess { listOfPostModel ->
            listOfPostModel.map { postModel ->
                when (postModel.userState) {
                    UserState.NORMAL -> setupNormalPost(postModel, false)
                    UserState.HAS_WARNING -> setupNormalPost(postModel, true)
                    UserState.BANNED -> setupBannedPost(postModel)
                }
            }
        }.mapError { resourceRepository.getString(R.string.post_loading_error) }
    }

    private fun setupNormalPost(postModel: PostModel, hasWarning: Boolean): StandardPost {
        var backgroundColorResource = R.color.white
        var textColorResource = R.color.black
        if (hasWarning){
            backgroundColorResource = R.color.red
            textColorResource = R.color.white
        }
        return StandardPost(
            userId = postModel.userId.toString(),
            title = postModel.title,
            body = postModel.body,
            hasWarning = hasWarning,
            textColor = resourceRepository.getColor(textColorResource),
            backgroundColor = resourceRepository.getColor(backgroundColorResource)
        )
    }

    private fun setupBannedPost(postModel: PostModel): BannedPost {
        return BannedPost(
            warningText = String.format(
                resourceRepository.getString(R.string.banned_text),
                postModel.userId
            ),
            backgroundColor = resourceRepository.getColor(R.color.black),
            textColor = resourceRepository.getColor(R.color.white)
        )
    }
}