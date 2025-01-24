package com.example.mystud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        usernameEditText = findViewById(R.id.un1)
        passwordEditText = findViewById(R.id.pas1)
        loginButton = findViewById(R.id.login)

        // Set click listener for the login button
        loginButton.setOnClickListener {
            validateLogin()
        }
    }

    private fun validateLogin() {
        // Get the username and password from the EditText fields
        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Validate input fields
        if (username.isEmpty() || password.isEmpty()) {
            // Show a message if either field is empty
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
        } else if (username == "admin" && password == "password123") {
            // Show success message if the credentials are correct
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {
            // Show error message if credentials are incorrect
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
        }
    }
}
