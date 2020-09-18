package com.example.weatherapp.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY= "3a41f8f74e104e612860c4a2ad20f412"

interface ApiInterface {
    @GET("weather?appid=$API_KEY &units=metric")
    fun getWeatherData(@Query("q") name: String?): Call<Example?>?
}

