package com.example.nurafshonpm.Activities.activities.login.sharedData

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsManager(context: Context) {

    private var prefs: SharedPreferences =
        context.getSharedPreferences("saveToken", Context.MODE_PRIVATE)


    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString("token", null)
    }

}