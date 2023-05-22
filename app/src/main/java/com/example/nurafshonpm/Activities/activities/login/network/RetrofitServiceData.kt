package com.example.nurafshonpm.Activities.activities.login.network

import com.example.nurafshonpm.Activities.activities.login.model.SignUpRequest
import com.example.nurafshonpm.Activities.activities.login.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitServiceData {

    @Headers("Content-type:application/json")

    @POST("signup")
    fun signUpPost(@Body signUpRequest: SignUpRequest): Call<SignUpResponse>
}