package com.example.home_task_mvvm_livedata

import android.content.Intent
import androidx.core.widget.addTextChangedListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.home_task_mvvm_livedata.databinding.InputNewPostActivityBinding
import com.example.home_task_mvvm_livedata.di.AppModule
import com.example.home_task_mvvm_livedata.di.DaggerAppComponent
import com.example.home_task_mvvm_livedata.ui.MainViewModel
import kotlinx.android.synthetic.main.input_new_post_activity.*
import javax.inject.Inject

class InputNewPostActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel
    private lateinit var binding: InputNewPostActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.input_new_post_activity)
        setupListeners()

        DaggerAppComponent
            .builder()
            .appModule(AppModule(AppApplication()))
            .build()
            .inject(this)
    }

    private fun setupListeners(){
        binding.confirmBtn.setOnClickListener {
            viewModel.putNewPost(et1.text.toString(), et2.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}