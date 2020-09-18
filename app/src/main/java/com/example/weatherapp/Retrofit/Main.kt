package com.example.weatherapp.Retrofit

data class Main(var temp:String, var humidity:String, var feels_like:String)

/*import com.google.gson.annotations.SerializedName
class Main {
    @SerializedName("temp")
    var temp: String? = null

    @SerializedName("humidity")
    var humidity: String? = null

    @SerializedName("feels_like")
    var feels_like: String? = null
}*/