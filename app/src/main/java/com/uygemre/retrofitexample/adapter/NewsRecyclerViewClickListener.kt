package com.uygemre.retrofitexample.adapter

import com.uygemre.retrofitexample.model.IBaseModel

interface NewsRecyclerViewClickListener {
    fun onClickListener(position: Int, model: IBaseModel)
}