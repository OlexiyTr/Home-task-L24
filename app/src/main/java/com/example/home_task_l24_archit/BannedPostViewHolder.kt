package com.example.home_task_l24_archit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.home_task_l24_archit.PresenterLayer.PostUiModel
import com.example.home_task_l24_archit.databinding.BannedPostBinding

class BannedPostViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding: BannedPostBinding by lazy {
        BannedPostBinding.bind(view)
    }

    fun onBind(bannedPost: PostUiModel.BannedPost) {
        binding.apply {
            holderBannedContainer.setBackgroundColor(bannedPost.backgroundColor)
            tvWarning.text = bannedPost.warningText
            tvWarning.setTextColor(bannedPost.textColor)
        }
    }
}