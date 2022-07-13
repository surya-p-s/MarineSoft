package com.example.marinesoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DetailsPage : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)

        auth = Firebase.auth

        val signOut = findViewById<Button>(R.id.signOut)

        signOut.setOnClickListener {
            Firebase.auth.signOut()
            updateUI()
        }

    }

    private fun updateUI() {

        Toast.makeText(baseContext, "SignOut Successfully",
            Toast.LENGTH_LONG).show()

        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}