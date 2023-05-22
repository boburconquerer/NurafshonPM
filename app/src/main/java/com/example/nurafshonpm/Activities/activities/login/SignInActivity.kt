package com.example.nurafshonpm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.nurafshonpm.Activities.activities.activity.MainActivity
import com.example.nurafshonpm.Activities.activities.login.SignUpActivity
import com.example.nurafshonpm.Activities.activities.login.model.SignInRequest
import com.example.nurafshonpm.Activities.activities.login.model.SignInResponse
import com.example.nurafshonpm.Activities.activities.login.network.RetrofitHTTPData
import com.example.nurafshonpm.Activities.activities.login.sharedData.SharedPrefsManager
import com.example.nurafshonpm.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var signInButton: AppCompatButton
    lateinit var signUpFromHere: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()
    }

    private fun whenClicked() {
        signUpFromHere = findViewById(R.id.SignUpFromHere)
        signUpFromHere.setOnClickListener{
            val intent = Intent(this@SignInActivity,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {

        apiSignUp()
        whenClicked()

        signInButton = findViewById(R.id.signInButton_id)
        signInButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun apiSignUp() {
        val signInEmail = findViewById<TextView>(R.id.email)
        val signInPassword = findViewById<TextView>(R.id.password)

        val email = signInEmail.text.toString().trim()
        val password = signInPassword.text.toString().trim()

        val progress = findViewById<ProgressBar>(R.id.progress_sign_in)
        progress.visibility = View.VISIBLE

        val signInRequest = SignInRequest( email, password)
        RetrofitHTTPData.retrofitServiceData().signInPost(signInRequest).enqueue(object :
            Callback<SignInResponse> {

            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                progress.visibility = View.GONE
                if (response.isSuccessful){

                    val data = response.body()
                    val sharedPrefsManager = SharedPrefsManager(this@SignInActivity)
                    sharedPrefsManager.saveAuthToken(data!!.token)
                    Log.d("@s", response.body().toString())
                    val intent = Intent(this@SignInActivity,MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(
                        this@SignInActivity,
                        "Welcome to Nurafshon PM",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                progress.visibility = View.GONE
                Log.d("@e", t.message.toString())
                Toast.makeText(
                    this@SignInActivity,
                    "No internet connection or log in error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}