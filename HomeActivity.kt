package com.example.mystud

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView
    private lateinit var startServiceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        welcomeTextView = findViewById(R.id.welcomeText)
        startServiceButton = findViewById(R.id.startService)

        // Set welcome message
        welcomeTextView.text = "Welcome to the Home Activity!"

        // Start the background service on button click
        startServiceButton.setOnClickListener {
            val intent = Intent(this, BackgroundService::class.java)
            startService(intent)
            Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
        }
    }
}
