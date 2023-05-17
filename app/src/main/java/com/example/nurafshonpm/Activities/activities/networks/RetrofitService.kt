package com.example.nurafshonpm.Activities.activities.networks

import com.example.nurafshonpm.Activities.activities.fragments.model.RatingData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {

    @Headers("Content-type:application/json")

    @GET("rating")
    fun  ratingList():Call<RatingData>

}