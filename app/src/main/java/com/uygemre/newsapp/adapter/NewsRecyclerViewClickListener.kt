package com.uygemre.newsapp.adapter

import com.uygemre.newsapp.model.IBaseModel

interface NewsRecyclerViewClickListener {
    fun onClickListener(position: Int, model: IBaseModel)
}