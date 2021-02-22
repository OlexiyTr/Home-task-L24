package com.example.home_task_mvvm_livedata.ui

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home_task_mvvm_livedata.databinding.BannedPostBinding
import com.example.home_task_mvvm_livedata.ui.PostUiModel.BannedPost

class BannedPostViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val binding = DataBindingUtil.bind<BannedPostBinding>(view)

    fun onBind(model : BannedPost){
        binding?.model = model
    }
}