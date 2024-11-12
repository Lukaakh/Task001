package com.example.task001

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val messageInput = findViewById<EditText>(R.id.messageInput)
        val sendButton = findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val email = emailInput.text.toString()
            val message = messageInput.text.toString()

            if (validateEmail(email) && validateMessage(message)) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("EMAIL", email)
                intent.putExtra("MESSAGE", message)
                startActivity(intent)
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return if (email.contains("@")) {
            true
        } else {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun validateMessage(message: String): Boolean {
        return if (message.isNotEmpty() && message.length <= 250) {
            true
        } else {
            Toast.makeText(this, "Message must be between 1 and 250 characters", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
