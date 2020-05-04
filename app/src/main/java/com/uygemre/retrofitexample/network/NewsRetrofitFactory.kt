package com.uygemre.retrofitexample.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRetrofitFactory {
    companion object{
        var BASE_URL = "https://api.collectapi.com/"
        fun getNewsInformation() : NewsApi{
//            val logInterceptor = HttpLoggingInterceptor()
//            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
//            val client = OkHttpClient.Builder()
//                .addInterceptor(logInterceptor)
//                .build()

            val retrofit : Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(NewsApi::class.java)
        }
    }
}