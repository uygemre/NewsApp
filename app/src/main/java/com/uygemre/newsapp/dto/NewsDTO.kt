package com.uygemre.newsapp.dto

import com.uygemre.newsapp.model.IBaseModel
import com.uygemre.newsapp.model.IBaseModel.Companion.NEWS_CARD

data class NewsDTO(
    var description: String?,
    var name: String?,
    var image: String?,
    var isSelect: Boolean? = false,
    var url: String?
) : IBaseModel {
    override val type: Int
        get() = NEWS_CARD
}