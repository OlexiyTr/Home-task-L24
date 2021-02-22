package com.example.home_task_mvvm_livedata.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.home_task_mvvm_livedata.R
import java.io.Serializable

class PostUIAdapter: ListAdapter<PostUiModel, RecyclerView.ViewHolder>(DiffCallbackPostAdapter()),
    Serializable {

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
            is NormalPostViewHolder -> {
                holder.onBind(getItem(position) as PostUiModel.StandardPost)
            }
            is BannedPostViewHolder -> {
                holder.onBind(getItem(position) as PostUiModel.BannedPost)
            }
        }
    }


    private val _items: MutableList<PostUiModel>? = mutableListOf<PostUiModel>()
    var items = _items
    override fun getItemCount(): Int {
        if (items == null){
            return 0
        }
        return items!!.size
    }

    fun updateAdapter(newList: List<PostUiModel>) {
        items?.clear()
        items?.addAll(newList)
        notifyDataSetChanged()
    }

}

