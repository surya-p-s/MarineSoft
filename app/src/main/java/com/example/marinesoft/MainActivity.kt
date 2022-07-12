package com.example.marinesoft

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val registerButton = findViewById<Button>(R.id.registerButton)
        val signIn = findViewById<Button>(R.id.signInButton)

        registerButton.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        signIn.setOnClickListener{
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)

        }
    }
}