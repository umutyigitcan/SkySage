package com.example.skysage.network




data class ApiResponse(
    val name:String,
    val main:Main,
    val weather:List<Weather>
)

data class Main(
    var temp:Double
)

data class Weather(
    val description:String
)