package com.example.techtest_android2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameInput = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.username_input)
            .editText
        val passwordInput = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.password_input)
            .editText
        val loginButton = findViewById<Button>(R.id.login_button)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)

        loginButton.setOnClickListener {
            val username = usernameInput?.text.toString()
            val password = passwordInput?.text.toString()

            // Tampilkan ProgressBar
            progressBar.visibility = android.view.View.VISIBLE
            loginButton.isEnabled = false

            // Simulasikan proses loading menggunakan Handler
            Handler(Looper.getMainLooper()).postDelayed({
                // Sembunyikan ProgressBar
                progressBar.visibility = android.view.View.GONE
                loginButton.isEnabled = true

                if (username == "alfagift-admin" && password == "asdf") {
                    val intent = Intent(this, StudentListActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }, 3000) // Simulasi loading selama 3 detik
        }
    }
}
