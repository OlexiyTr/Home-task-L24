package com.example.home_task_l24_archit.Utils

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

class ResourceRepository(private val context: Context) {
    fun getColor(@ColorRes colorRes: Int) = ContextCompat.getColor(context, colorRes)

    fun getString(@StringRes stringRes: Int) = context.resources.getString(stringRes)
}