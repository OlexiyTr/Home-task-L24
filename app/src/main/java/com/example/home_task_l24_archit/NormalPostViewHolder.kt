package com.example.home_task_l24_archit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.home_task_l24_archit.PresenterLayer.PostUiModel
import com.example.home_task_l24_archit.databinding.NormalPostBinding

class NormalPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding: NormalPostBinding by lazy {
        NormalPostBinding.bind(view)
    }

    fun onBind(standardPost: PostUiModel.StandardPost) {
        binding.apply {
            holderStandartContainer.setBackgroundColor(standardPost.backgroundColor)
            tvUserId.apply {
                text = standardPost.userId
                setTextColor(standardPost.textColor)
            }
            tvTitle.apply {
                text = standardPost.title
                setTextColor(standardPost.textColor)
            }
            tvWarning.setTextColor(standardPost.textColor)
            tvBody.apply {
                setTextColor(standardPost.textColor)
                text = standardPost.body
            }
            if (standardPost.hasWarning) {
                tvWarning.visibility = View.VISIBLE
            } else {
                tvWarning.visibility = View.GONE
            }
        }
    }
}
