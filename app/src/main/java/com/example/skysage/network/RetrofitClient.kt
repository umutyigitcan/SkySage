package com.example.skysage.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

object RetrofitClient {

    private const val URL="https://api.openweathermap.org/"

    val instance:Retrofit by lazy {
        Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
    }


}