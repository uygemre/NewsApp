package com.uygemre.retrofitexample.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.retrofitexample.adapter.NewsRecyclerViewClickListener
import com.uygemre.retrofitexample.model.IBaseModel

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bindView(baseModel: IBaseModel,position: Int, click: NewsRecyclerViewClickListener)
}