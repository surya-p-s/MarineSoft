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

class SignInActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var loginemail : EditText
    private lateinit var loginpassword : EditText

    private lateinit var sEmail : String
    private lateinit var sPassword : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        auth = Firebase.auth

        val signIn = findViewById<Button>(R.id.signIn)

        loginemail =findViewById(R.id.emailText1)
        loginpassword = findViewById(R.id.textPassword1)


        signIn.setOnClickListener{
            sEmail = loginemail.text.toString().trim()
            sPassword = loginpassword.text.toString().trim()

            auth.signInWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    Log.d(TAG,"signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                }
                else{
                    Log.w(TAG,"signInWithEmail:failure",task.exception)
                    Toast.makeText(baseContext, "Authentication Failed.",
                        Toast.LENGTH_SHORT).show()
                        updateUI(null)
                }
            }

        }


    }



    private fun updateUI(user: FirebaseUser?){
        val intent=Intent(this, DetailsPage::class.java)
        intent.putExtra("data",user)
        startActivity(intent)
    }

}