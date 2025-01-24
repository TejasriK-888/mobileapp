package com.example.mystud

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

class BoundService : Service() {

    // Binder to allow communication between service and activity
    private val binder = LocalBinder()

    // Method to provide real-time updates to the activity
    fun getProfileData(): String {
        return "Profile data: User - Admin"
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    // LocalBinder class to bind service to the activity
    inner class LocalBinder : Binder() {
        fun getService(): BoundService {
            return this@BoundService
        }
    }
}
