package com.example.home_task_l24_archit.Utils

import android.content.Context
import android.os.Handler
import com.example.home_task_l24_archit.AsyncOperation

class Multithreading(context: Context) {
    private val mainHandler = Handler(context.mainLooper)

    fun <T> async(operation: () -> T): AsyncOperation<T> {
        return AsyncOperation(
            operation = operation,
            mainHandler = mainHandler,
            threadCreation = ::createThread
        )
    }

    private fun createThread(runnable: Runnable) : Thread {
        return Thread(runnable).apply(Thread::start)
    }
}
