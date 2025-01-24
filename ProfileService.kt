package com.example.mystud

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.google.firebase.database.FirebaseDatabase

class ProfileService : Service() {

    private val binder = ProfileBinder()

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    // This method will allow the HomeActivity to interact with the profile data
    fun getUserProfile(): UserProfile {
        // Return the current user profile data
        return UserProfile("John Doe", "john.doe@example.com")
    }

    fun updateUserProfile(name: String, email: String) {
        // Save the updated user profile data to Firebase
        val database = FirebaseDatabase.getInstance()
        val profileRef = database.getReference("users").child("user_id") // Replace with the actual user ID

        val userProfile = UserProfile(name, email)

        profileRef.setValue(userProfile).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // If the update was successful
            } else {
                // If the update failed
            }
        }
    }

    // Binder to interact with the service from HomeActivity
    inner class ProfileBinder : Binder() {
        fun getService(): ProfileService = this@ProfileService
    }
}
