package com.uygemre.newsapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.newsapp.adapter.NewsRecyclerViewClickListener
import com.uygemre.newsapp.model.IBaseModel

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bindView(
        baseModel: IBaseModel,
        position: Int,
        click: NewsRecyclerViewClickListener
    )
}