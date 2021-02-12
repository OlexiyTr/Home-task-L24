package com.example.home_task_l24_archit.PresenterLayer

import com.example.home_task_l24_archit.CancelableOperation
import com.example.home_task_l24_archit.DataLayer.PostDataRepository
import com.example.home_task_l24_archit.Shared.Result
class PostPresenter (
    private val postDataRepository: PostDataRepository,
    private val postUiMapper: PostUiMapper
) {

    private var attachedView: PostView? = null
    private var cancelableOperation: CancelableOperation? = null

    fun attachView(postView: PostView) {
        attachedView = postView

        cancelableOperation = postDataRepository.getPosts()
            .map(postUiMapper::map)
            .postOnMainThread(::showResult)
    }

    fun detachView() {
        attachedView = null
        cancelableOperation?.cancel()
    }

    private fun showResult(result: Result<List<PostUiModel>, String>) {
        if (result.isError) {
            attachedView?.showError(result.errorResult)
        }
        else {
            attachedView?.showPosts(result.successResult)
        }
    }
}