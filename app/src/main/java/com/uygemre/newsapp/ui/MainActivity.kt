package com.uygemre.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uygemre.newsapp.R
import com.uygemre.newsapp.adapter.NewsRecyclerViewAdapter
import com.uygemre.newsapp.adapter.NewsRecyclerViewClickListener
import com.uygemre.newsapp.dto.NewsDTO
import com.uygemre.newsapp.model.IBaseModel
import com.uygemre.newsapp.model.NewsModel
import com.uygemre.newsapp.network.NewsRetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewNewsAdapter: NewsRecyclerViewAdapter
    private val newsList = mutableListOf<IBaseModel>()

    var recyclerViewClickListener = object : NewsRecyclerViewClickListener {
        override fun onClickListener(position: Int, model: IBaseModel) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRecyclerViewAdapter()

        val apiService = NewsRetrofitFactory.getNewsInformation().getNews()
        apiService.enqueue(object : Callback<NewsModel> {
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                response.body().let {
                    it?.result?.map { result ->
                        val news = NewsDTO(
                            description = result?.description ?: "",
                            name = result?.name ?: "",
                            image = result?.image ?: "",
                            url = result?.url ?: ""
                        )

                        newsList.add(news)
                    }

                    recyclerViewNewsAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun getRecyclerViewAdapter() {
        recyclerViewNewsAdapter = NewsRecyclerViewAdapter(newsList, recyclerViewClickListener)
        list_news_recyclerview.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )

        list_news_recyclerview.adapter = recyclerViewNewsAdapter
    }
}
