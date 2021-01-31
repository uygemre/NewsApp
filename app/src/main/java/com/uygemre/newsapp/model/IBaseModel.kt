package com.uygemre.newsapp.model

interface IBaseModel {
    val type: Int?

    companion object {
        const val NEWS_CARD = 1
    }
}
