package com.example.home_task_l24_archit.DataLayer

import com.example.home_task_l24_archit.AsyncOperation
import com.example.home_task_l24_archit.DomainLayer.PostModel
import com.example.home_task_l24_archit.DomainLayer.PostModelMapper
import com.example.home_task_l24_archit.Shared.Errors
import com.example.home_task_l24_archit.Utils.Multithreading
import com.example.home_task_l24_archit.Utils.PostAPIService
import com.example.home_task_l24_archit.Shared.Result

class PostDataRepository(
    private val multithreading: Multithreading,
    private val postAPIService: PostAPIService,
    private val postModelMapper: PostModelMapper
) {

    fun getPosts(): AsyncOperation<Result<List<PostModel>, Errors>> {
        val asyncOperation = multithreading.async<Result<List<PostData>, Errors>> {
            val postsData: List<PostData>? = postAPIService.getPostsFromAPI().execute().body()

            postsData?.let {
                return@async Result.success(it)
            }
            return@async Result.error(Errors.POST_LOADING_ERROR)
        }

        return asyncOperation.map(postModelMapper::map)
    }
}