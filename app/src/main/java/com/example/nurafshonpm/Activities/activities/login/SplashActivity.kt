package com.example.nurafshonpm.Activities.activities.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.nurafshonpm.Activities.SignInActivity
import com.example.nurafshonpm.Activities.activities.activity.MainActivity
import com.example.nurafshonpm.Activities.activities.login.sharedData.SharedPrefsManager
import com.example.nurafshonpm.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initViews()
    }

    private fun initViews() {
        timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {

                val sharedPrefsManager = SharedPrefsManager(this@SplashActivity)
                if (sharedPrefsManager.fetchAuthToken() != null ) {

                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@SplashActivity, SignInActivity::class.java)
                    startActivity(intent)
                }
                finish()
            }

        }.start()


    }

}