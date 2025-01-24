package com.example.mystud

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast

class BackgroundService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Simulate a long-running task
        Handler(mainLooper).postDelayed({
            Toast.makeText(this, "User profile data downloaded", Toast.LENGTH_SHORT).show()
            stopSelf() // Stop the service after task completion
        }, 5000) // Simulates a 5-second task

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
