package com.example.tryservicekotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SimpleTaskService : Service() {

    companion object {
        val TAG = "TryService SimpleTaskService"
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.v(TAG,"SimpleTaskService is ready to conquer!")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(TAG,"SimpleTaskService is performing a task! Don't disturb, please!")
        performLongTask()
        return START_STICKY // If the service is killed, it will be automatically restarted
    }

    private fun performLongTask() {
        // Imagine doing something that takes a long time here
        Thread.sleep(5000)
        Log.v(TAG,"SimpleTaskService is done performing a task! Stop me now!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"SimpleTaskService says goodbye!")
    }

}