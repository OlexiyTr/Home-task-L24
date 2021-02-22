package com.example.home_task_mvvm_livedata.ui

import android.annotation.SuppressLint
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home_task_mvvm_livedata.R
import com.example.home_task_mvvm_livedata.databinding.NormalPostBinding

class NormalPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = DataBindingUtil.bind<NormalPostBinding>(view)

    @SuppressLint("ResourceAsColor")
    fun onBind(standardPost: PostUiModel.StandardPost) {
        binding?.model = standardPost
        if (standardPost.hasWarning) {
            binding?.tvWarning?.visibility = View.VISIBLE
        } else {
            binding?.tvWarning?.visibility = View.GONE
        }
    }
}
