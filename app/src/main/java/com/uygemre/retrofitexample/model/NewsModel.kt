package com.uygemre.retrofitexample.model

data class NewsModel(
    var result : List<Result>
)
data class Result(
    var description : String,
    var name : String,
    var image : String,
    var url : String
)
