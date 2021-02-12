package com.example.home_task_l24_archit

import androidx.recyclerview.widget.DiffUtil
import com.example.home_task_l24_archit.PresenterLayer.PostUiModel

class DiffCallbackPostAdapter: DiffUtil.ItemCallback<PostUiModel>() {
    override fun areItemsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
        return oldItem == newItem
    }

}