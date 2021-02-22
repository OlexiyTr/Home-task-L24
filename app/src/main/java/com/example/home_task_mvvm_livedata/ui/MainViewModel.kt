package com.example.home_task_mvvm_livedata.ui

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home_task_mvvm_livedata.domain.use_cases.GetPostsUseCase
import com.example.home_task_mvvm_livedata.domain.use_cases.NewPostState
import com.example.home_task_mvvm_livedata.domain.use_cases.PutNewPostUseCase
import com.example.home_task_mvvm_livedata.domain.use_cases.ValidateUseCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val putNewPostUserCase: PutNewPostUseCase,
    private val validateUseCase: ValidateUseCase
) : ViewModel() {
    private val _postsLiveData = MutableLiveData<List<PostUiModel>>()
    val postsLiveData: LiveData<List<PostUiModel>> = _postsLiveData

    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getPostsUseCase.execute()
            withContext(Dispatchers.Main) {
                result?.also { repos ->
                    _postsLiveData.postValue(repos)
                }
            }
        }
    }

    fun putNewPost(title: String, body: String) {
        if (validateUseCase.validate(title, body) == NewPostState.ValidPost) {
            putNewPostUserCase.put(title, body)
        }
    }
}