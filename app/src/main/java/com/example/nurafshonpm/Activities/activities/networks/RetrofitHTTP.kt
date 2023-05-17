package com.example.nurafshonpm.Activities.activities.networks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHTTP {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://nurafshon-pm.up.railway.app/api/")
            .build()
    }

    fun retrofitService(): RetrofitService {
        return getRetrofit().create(RetrofitService::class.java)
    }
}