package com.example.skysage.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("data/2.5/weather")
    fun getData(
        @Query("q") cityName:String,
        @Query("appid") apiKey:String,
        @Query("units") units:String="metric"
    ):Call<ApiResponse>



}