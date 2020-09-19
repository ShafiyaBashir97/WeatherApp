package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weatherapp.Retrofit.*
import com.example.weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val searchbox = binding.textField
        val search_icon = binding.searchImageView

        //val temperature = binding.tempText
        //val description = binding.descText
        //val humidity = binding.humidityText

        search_icon.setOnClickListener {
            getWeatherData(searchbox.text.toString())

        }


    }

    private fun getWeatherData(name: String)
    {
        val example =ApiClient.apiInterface.getWeatherData(name)
            example.enqueue(object : Callback<Example> {
                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    println("Response is" + response.body())
                }

                override fun onFailure(call: Call<Example>, t: Throwable) {
                    Log.d("Error","Error in Fetching the News",t)
                }

                //@SuppressLint("SetTextI18n")
                //override fun onResponse(call: Call<Example>, response: Response<Example?>)
                // {
                // val example =response.body()
                //  println("Response is" + response.body())


                /* try {
                        if (example != null) {
                            binding.tempText.setText("Temp" + " " + example.main.temp + " C")
                            // mistake expected (calling variables from main)
                        }
                        if (example != null) {
                            binding.descText.setText("Feels Like" + " " + example.main.feels_like)
                            // mistake expected
                        }
                        if (example != null) {
                            binding.humidityText.setText("Humidity" + " " + example.main.humidity)
                            // mistake expected
                        }
                    }

                    catch (e: Exception)
                    {
                        e.printStackTrace()
                    }*/
                // }

                //  override fun onFailure(call: Call<Example?>?, t: Throwable?) {
                // Log.d("Error","Error in Fetching the News",t)
                //  }
            })
    


    }
}







