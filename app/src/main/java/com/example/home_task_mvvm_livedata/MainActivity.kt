package com.example.home_task_mvvm_livedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home_task_mvvm_livedata.databinding.ActivityMainBinding
import com.example.home_task_mvvm_livedata.di.AppModule
import com.example.home_task_mvvm_livedata.di.DaggerAppComponent
import com.example.home_task_mvvm_livedata.ui.MainViewModel
import com.example.home_task_mvvm_livedata.ui.PostUIAdapter
import com.example.home_task_mvvm_livedata.ui.PostUiModel

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var adapter: PostUIAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent
            .builder()
            .appModule(AppModule(AppApplication()))
            .build()
            .inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        observePosts()
        setupAdapter()
        viewModel.getPosts()
        setupListeners()
    }

    private fun observePosts() {
        viewModel.postsLiveData.observe(this, Observer {
            updatePosts(it)
        })
    }

    private fun setupAdapter() {
        adapter = PostUIAdapter()
        binding.rvPosts.adapter = adapter
        binding.rvPosts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun updatePosts(items: List<PostUiModel>) {
        adapter?.updateAdapter(items)
        adapter?.submitList(items)
    }

    private fun setupListeners() {
            binding.btnAddPost.setOnClickListener {
            val intent = Intent(this, InputNewPostActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

}