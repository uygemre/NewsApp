package com.uygemre.retrofitexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.retrofitexample.R
import com.uygemre.retrofitexample.adapter.NewsRecyclerViewAdapter
import com.uygemre.retrofitexample.adapter.NewsRecyclerViewClickListener
import com.uygemre.retrofitexample.dto.NewsDTO
import com.uygemre.retrofitexample.model.IBaseModel
import com.uygemre.retrofitexample.model.NewsModel
import com.uygemre.retrofitexample.network.NewsRetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewNewsAdapter : NewsRecyclerViewAdapter
    lateinit var recyclerViewNews : RecyclerView
    private val newsList = mutableListOf<IBaseModel>()

    var recyclerViewClickListener=object:NewsRecyclerViewClickListener{
        override fun onClickListener(position: Int, model: IBaseModel) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRecyclerViewAdapter()

        val apiService = NewsRetrofitFactory.getNewsInformation().getNews()
        apiService.enqueue(object:Callback<NewsModel>{
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {

            }
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                response.body().let {
                    it!!.result.forEach {
                        var news= NewsDTO(
                            description = it.description,
                            name = it.name,
                            image = it.image,
                            url = it.url
                        )
                        newsList.add(news)
                    }
                    recyclerViewNewsAdapter.notifyDataSetChanged()
                }
            }
        })
    }
    private fun getRecyclerViewAdapter() {
        recyclerViewNews = findViewById(R.id.list_news_recyclerview)
        recyclerViewNewsAdapter = NewsRecyclerViewAdapter(newsList, recyclerViewClickListener)
        recyclerViewNews.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerViewNews.adapter = recyclerViewNewsAdapter
    }
}
