package com.uygemre.retrofitexample.dto

import com.uygemre.retrofitexample.model.IBaseModel
import com.uygemre.retrofitexample.model.IBaseModel.Companion.NEWS_CARD

data class NewsDTO(
    var description : String,
    var name : String,
    var image : String,
    var isSelect : Boolean = false,
    var url : String
): IBaseModel {
    override val type : Int
        get() = NEWS_CARD
}