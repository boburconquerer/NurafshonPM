package com.example.nurafshonpm.Activities.activities.login.network

import com.example.nurafshonpm.Activities.activities.networks.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHTTPData {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://nurafshon-pm.up.railway.app/api/users/")
            .build()
    }

    fun retrofitServiceData(): RetrofitServiceData {
        return getRetrofit().create(RetrofitServiceData::class.java)
    }
}