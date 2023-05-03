package com.example.nurafshonpm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.nurafshonpm.Activities.activities.activity.MainActivity
import com.example.nurafshonpm.Activities.activities.login.SignUpActivity
import com.example.nurafshonpm.R

//Edit by Paxriddinov
class SignInActivity : AppCompatActivity() {
    private lateinit var signInButton: AppCompatButton
    lateinit var signUpFromHere: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()
        WhenClicked()
    }

    private fun WhenClicked() {
        signUpFromHere = findViewById(R.id.SignUpFromHere)
        signUpFromHere.setOnClickListener{
            val intent = Intent(this@SignInActivity,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        signInButton = findViewById(R.id.signInButton_id)
        signInButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}