package com.example.task001

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val emailDisplay = findViewById<TextView>(R.id.emailDisplay)
        val messageDisplay = findViewById<TextView>(R.id.messageDisplay)
        val clearButton = findViewById<Button>(R.id.clearButton)

        // Get the email and message from the intent
        val email = intent.getStringExtra("EMAIL")
        val message = intent.getStringExtra("MESSAGE")

        // Display the email and message
        emailDisplay.text = email
        messageDisplay.text = message

        clearButton.setOnClickListener {
            emailDisplay.text = ""
            messageDisplay.text = ""
        }
    }
}
