package com.example.nurafshonpm.Activities.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.nurafshonpm.Activities.SignInActivity
import com.example.nurafshonpm.Activities.activities.activity.MainActivity
import com.example.nurafshonpm.Activities.activities.login.model.SignInRequest
import com.example.nurafshonpm.Activities.activities.login.model.SignInResponse
import com.example.nurafshonpm.Activities.activities.login.model.SignUpRequest
import com.example.nurafshonpm.Activities.activities.login.model.SignUpResponse
import com.example.nurafshonpm.Activities.activities.login.network.RetrofitHTTPData
import com.example.nurafshonpm.Activities.activities.login.sharedData.SharedPrefsManager
import com.example.nurafshonpm.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var singUpButton: AppCompatButton
    lateinit var signInFromHere: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
    }

    private fun whenClicked() {
        signInFromHere = findViewById(R.id.signInFromHere)
        signInFromHere.setOnClickListener{
            val intent = Intent(this@SignUpActivity,SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        whenClicked()
        apiSignUp()

        singUpButton=findViewById(R.id.signUpButton_id)
        singUpButton.setOnClickListener {
            val intent = Intent(this@SignUpActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun apiSignUp() {
        val signUpUserName = findViewById<TextView>(R.id.signUpUserName)
        val signUpEmail = findViewById<TextView>(R.id.signUpEmail)
        val signUpPassword = findViewById<TextView>(R.id.signUpPassword)
        val fullName = signUpUserName.text.toString().trim()
        val email = signUpEmail.text.toString().trim()
        val password = signUpPassword.text.toString().trim()
        val progress = findViewById<ProgressBar>(R.id.progress_sign_up)
        progress.visibility = View.VISIBLE
        val signUpRequest = SignUpRequest(fullName, email, password)
        RetrofitHTTPData.retrofitServiceData().signUpPost(signUpRequest).enqueue(object :Callback<SignUpResponse>{

            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                progress.visibility = View.GONE
                if (response.isSuccessful){

                    val data = response.body()
                    val sharedPrefsManager = SharedPrefsManager(this@SignUpActivity)
                    sharedPrefsManager.saveAuthToken(data!!.token)

                    val intent = Intent(this@SignUpActivity,MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        this@SignUpActivity,
                        "Welcome to Nurafshon PM",
                        Toast.LENGTH_SHORT
                    ).show()

                }




            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                progress.visibility = View.GONE
                Toast.makeText(
                    this@SignUpActivity,
                    "No internet connection or log in error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }


}