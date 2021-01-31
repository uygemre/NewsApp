package com.uygemre.newsapp.network

import com.uygemre.newsapp.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsApi {

    @Headers("Authorization: apikey 2upQInH4DWGMkz07IJfP6e:1VzTt1k2BkNm9wR93lEZYA")
    @GET("news/getNews?country=tr&tag=general")
    fun getNews(): retrofit2.Call<NewsModel>

}