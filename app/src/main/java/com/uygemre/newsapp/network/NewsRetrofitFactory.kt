package com.uygemre.newsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRetrofitFactory {

    companion object {
        var BASE_URL = "https://api.collectapi.com/"
        fun getNewsInformation(): NewsApi {
            val retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(NewsApi::class.java)
        }
    }
}