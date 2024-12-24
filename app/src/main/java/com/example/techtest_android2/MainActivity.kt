package com.example.techtest_android2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengambil referensi ke TextInputLayout dan kemudian ke EditText
        val usernameInput = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.username_input)
            .editText // Mengambil EditText dari TextInputLayout
        val passwordInput = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.password_input)
            .editText // Mengambil EditText dari TextInputLayout
        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val username = usernameInput?.text.toString()
            val password = passwordInput?.text.toString()

            if (username == "alfagift-admin" && password == "asdf") {
                val intent = Intent(this, StudentListActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}