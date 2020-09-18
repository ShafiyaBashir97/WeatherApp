package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.weatherapp.Retrofit.*
import com.example.weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() 
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) 
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val searchbox = binding.textField
        val search_icon = binding.searchImageView
         //val temperature = binding.tempText
        //val description = binding.descText
       //val humidity = binding.humidityText

        search_icon.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                getWeatherData(searchbox.text.toString().trim())
            }
        })
           // getWeatherData(searchbox.text.toString().trim())


    }

    private fun getWeatherData(name: String) {
        val example=ApiClient.apiInterface?.getWeatherData("london")
            example?.enqueue(object : Callback<Example?> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<Example?>?, response: Response<Example?>)
                {
                    val example =response.body()
                    Log.e("CheezyCode",example.toString())
                    try {
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
                    }
                }

                override fun onFailure(call: Call<Example?>?, t: Throwable?) {
                    Log.d("CheezyCode","Error in Fetching the News",t)
                }
            })
        }
    
    
    }






