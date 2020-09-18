package com.example.weatherapp.Retrofit

import android.util.Base64
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//api.openweathermap.org/data/2.5/weather?q={city name}&appid={your api key}

const val BASE_URL="https://api.openweathermap.org/data/2.5/"
object ApiClient{
    var apiInterface : ApiInterface? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
        // this method is used to give the implementaion of passed interface
        //wherever we may need the above endpoint (the interface), we will call the "newsInstance"
    }
}
