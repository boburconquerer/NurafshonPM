package com.example.nurafshonpm.Activities.activities.networks

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.nurafshonpm.Activities.activities.app.App
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHTTP {

    private fun getRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(App.appContext!!).build())
            .addInterceptor(httpLoggingInterceptor).build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://nurafshon-pm.up.railway.app/api/")
            .client(okHttpClient)
            .build()
    }

    fun retrofitService(): RetrofitService {
        return getRetrofit().create(RetrofitService::class.java)
    }
}