package com.milliybank.admin.network

import com.milliybank.admin.homePage.modul.AdminHome
import com.milliybank.admin.homePage.modul.AdminHomeItem
import com.milliybank.admin.homePage.modul.PostData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {
    @Headers("Content-type:application/json")

    @POST("announcement")
    fun postAnnouncement(@Body postData: PostData):Call<AdminHomeItem>

    @GET("announcement")
    fun getAnnouncement():Call<AdminHome>


}