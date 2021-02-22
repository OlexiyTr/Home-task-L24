package com.example.home_task_mvvm_livedata.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("userId") val userId: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("body") val body: String? = null
) : Serializable