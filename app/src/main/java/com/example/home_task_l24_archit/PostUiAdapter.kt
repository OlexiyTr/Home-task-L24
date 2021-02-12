package com.example.home_task_l24_archit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.home_task_l24_archit.PresenterLayer.PostUiModel

class PostUiAdapter: ListAdapter<PostUiModel, RecyclerView.ViewHolder>(DiffCallbackPostAdapter()) {


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PostUiModel.StandardPost -> PostType.NORMAL
            is PostUiModel.BannedPost -> PostType.BANNED
        }.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewTypeEnum = PostType.values()[viewType]
        val view = if (viewTypeEnum == PostType.NORMAL) {
            LayoutInflater.from(parent.context).inflate(R.layout.normal_post, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.banned_post, parent, false)
        }

        return if (viewTypeEnum == PostType.NORMAL) {
            NormalPostViewHolder(view)
        } else {
            BannedPostViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NormalPostViewHolder -> holder.onBind(getItem(position) as PostUiModel.StandardPost)
            is BannedPostViewHolder ->  holder.onBind(getItem(position) as PostUiModel.BannedPost)

        }
    }
}