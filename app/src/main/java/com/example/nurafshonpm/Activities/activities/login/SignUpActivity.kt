package com.example.nurafshonpm.Activities.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.nurafshonpm.Activities.SignInActivity
import com.example.nurafshonpm.Activities.activities.activity.MainActivity
import com.example.nurafshonpm.R

class SignUpActivity : AppCompatActivity() {
    lateinit var singUpButton: AppCompatButton
    lateinit var signInFromHere: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
        WhenClicked()
    }

    private fun WhenClicked() {
        signInFromHere = findViewById(R.id.signInFromHere)
        signInFromHere.setOnClickListener{
            val intent = Intent(this@SignUpActivity,SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        singUpButton=findViewById(R.id.signUpButton_id)
        singUpButton.setOnClickListener {
            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

}