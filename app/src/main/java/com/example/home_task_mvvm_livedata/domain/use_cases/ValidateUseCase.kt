package com.example.home_task_mvvm_livedata.domain.use_cases

import javax.inject.Inject

class ValidateUseCase @Inject constructor() {
    private val badWords = setOf("реклама", "куплю", "товар")
    private val badRegex = badWords.joinToString(prefix = "(?i)", separator = "|").toRegex()

    fun validate(title: String, body: String): NewPostState {
        val titleErrors = mutableListOf<String>()
        val bodyErrors = mutableListOf<String>()

        if (title.length < 3) {
            titleErrors.add("Too short")
        } else if (title.length > 50) {
            titleErrors.add("Too long")
        }

        if (body.length < 5) {
            bodyErrors.add("Too short")
        } else if (body.length > 500) {
            bodyErrors.add("Too long")
        }

        if (title.contains(badRegex)) {
            titleErrors.add("Contains forbidden words")
        }

        return if (titleErrors.isNotEmpty() || bodyErrors.isNotEmpty()) {
            NewPostState.InvalidPost(titleErrors, bodyErrors)
        } else {
            NewPostState.ValidPost
        }
    }
}