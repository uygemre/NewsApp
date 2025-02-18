package com.uygemre.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.newsapp.R
import com.uygemre.newsapp.model.IBaseModel
import com.uygemre.newsapp.viewholder.BaseViewHolder
import com.uygemre.newsapp.viewholder.NewsViewHolder

class NewsRecyclerViewAdapter(
    var items: MutableList<IBaseModel>,
    var newsRecyclerViewClickListener: NewsRecyclerViewClickListener) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            IBaseModel.NEWS_CARD ->
                NewsViewHolder(
                    layoutInflater.inflate(
                        R.layout.list_news,
                        parent,
                        false)
                )
            else ->
                throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (items[position].type) {
            IBaseModel.NEWS_CARD ->
                (holder as NewsViewHolder).bindView(
                    items[position],
                    position,
                    newsRecyclerViewClickListener
                )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type ?: 0
    }
}