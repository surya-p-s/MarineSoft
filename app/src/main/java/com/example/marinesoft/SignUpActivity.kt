package com.example.marinesoft

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var signUp : Button

    private lateinit var sEmail : String
    private lateinit var sPassword : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = Firebase.auth
        signUp = findViewById(R.id.signUp)
        email = findViewById(R.id.emailText)
        password = findViewById(R.id.textPassword)


        signUp.setOnClickListener {

            sEmail = email.text.toString().trim()
            sPassword = password.text.toString().trim()

            auth.createUserWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT)
                            .show()
//                        updateUI(null)
                    }
                }

        }


    }

    private fun updateUI(user: FirebaseUser?) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)

    }


}