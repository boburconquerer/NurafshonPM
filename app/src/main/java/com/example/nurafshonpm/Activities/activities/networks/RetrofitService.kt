package com.example.nurafshonpm.Activities.activities.networks

import com.example.nurafshonpm.Activities.activities.fragments.model.RatingData
import com.example.nurafshonpm.Activities.activities.fragments.postModel.RatingRequest
import com.example.nurafshonpm.Activities.activities.fragments.postModel.RatingResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {
    //Hello

    @Headers("Content-type:application/json")

    @GET("rating")
    fun  ratingList():Call<RatingData>

    @POST("rating")
    fun ratingPost(@Body ratingRequest: RatingRequest):Call<RatingResponse>

}