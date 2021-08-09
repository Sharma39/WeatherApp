package com.example.weather_api.network

import android.util.Log
import com.example.weather_api.model.CitySearchResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class WeatherRetrofit {

//  https://weather.exam.bottlerocketservices.com/cities?search=Dallas&pageCount=10&pageNumber=1

//    https://weather.exam.bottlerocketservices.com/cities/cityID


    private val BASE_URL = "https://weather.exam.bottlerocketservices.com/"

    private val weatherEndPoint = createRetrofit().create(WeatherEndPoint::class.java)

    private fun createRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    suspend fun makeApiCallAsync(city: String): Deferred<CitySearchResponse> {
        Log.d("TAG_C", "$city in retrofit")
        return weatherEndPoint.getWeatherAsync(city)
    }

    interface WeatherEndPoint {


        //Endpoint
        @GET("cities")
        fun getWeatherAsync(
            @Query("search") city: String
//            @Query("pageCount") pageCount: Int,
//            @Query("pageNumber") pageNumber: Int
        ): Deferred<CitySearchResponse>

    }


    }