package com.example.tryservicekotlin

import android.app.IntentService
import android.content.Intent
import android.util.Log

class IntentTaskService : IntentService("IntentTaskService") {

    companion object {
        val TAG = "TryService BackgroundTaskService"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.v(TAG,"IntentTaskService is on a mission to conquer a task!")
        performLongTask()
    }

    private fun performLongTask() {
        // Imagine doing something that takes a long time here
        Thread.sleep(5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"IntentTaskService says farewell!")
    }
}