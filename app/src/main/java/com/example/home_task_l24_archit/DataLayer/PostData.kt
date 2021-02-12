package com.example.home_task_l24_archit.DataLayer

import com.google.gson.annotations.SerializedName

data class PostData (
    @SerializedName("id")
    val id : Int,
    @SerializedName("userId")
    val userId : Int,
    @SerializedName("title")
    val title : String,
    @SerializedName("body")
    val body : String,
)