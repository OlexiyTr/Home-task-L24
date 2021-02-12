package com.example.home_task_l24_archit.Utils

import android.content.Context
import com.example.home_task_l24_archit.DataLayer.PostDataRepository
import com.example.home_task_l24_archit.DomainLayer.PostModelMapper
import com.example.home_task_l24_archit.PresenterLayer.PostPresenter
import com.example.home_task_l24_archit.PresenterLayer.PostUiMapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostComponent {
    fun createPresenter(context: Context): PostPresenter {
        return PostPresenter(
            postDataRepository = PostDataRepository(
                multithreading = Multithreading(context),
                postAPIService = createService(),
                postModelMapper = PostModelMapper()
            ),
            postUiMapper = PostUiMapper(
                resourceRepository = ResourceRepository(context)
            )
        )
    }

    private fun createService(): PostAPIService {

        val baseUrlString = "https://jsonplaceholder.typicode.com/"

        return Retrofit.Builder()
            .baseUrl(baseUrlString)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostAPIService::class.java)
    }
}