package com.example.home_task_l24_archit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home_task_l24_archit.PresenterLayer.PostPresenter
import com.example.home_task_l24_archit.PresenterLayer.PostUiModel
import com.example.home_task_l24_archit.PresenterLayer.PostView
import com.example.home_task_l24_archit.Utils.PostComponent
import com.example.home_task_l24_archit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PostView {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var presenter: PostPresenter
    private val adapter by lazy {
        PostUiAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecycler()
        setupPresenter()
    }

    private fun setupPresenter() {
        presenter = PostComponent.createPresenter(this)
    }

    private fun setupRecycler() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.apply {
            rvPosts.layoutManager = linearLayoutManager
            rvPosts.adapter = adapter
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun showPosts(posts: List<PostUiModel>) {
        adapter.submitList(posts)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
