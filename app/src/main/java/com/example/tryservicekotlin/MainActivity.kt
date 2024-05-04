package com.example.tryservicekotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnStartService = findViewById<Button>(R.id.btnStartService)
        btnStartService.setOnClickListener(this)
        val btnStopService = findViewById<Button>(R.id.btnStopService)
        btnStopService.setOnClickListener(this)
        val btnStartIntentService = findViewById<Button>(R.id.btnStartIntentService)
        btnStartIntentService.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0?.id==R.id.btnStartService){
            val serviceStartIntent = Intent(this, SimpleTaskService::class.java)
            startService(serviceStartIntent)
        }else if(p0?.id==R.id.btnStopService){
            val serviceStopIntent = Intent(this, SimpleTaskService::class.java)
            stopService(serviceStopIntent)
        }else if(p0?.id==R.id.btnStartIntentService){
            val intentServiceStartIntent = Intent(this, IntentTaskService::class.java)
            startService(intentServiceStartIntent)
        }
    }
}