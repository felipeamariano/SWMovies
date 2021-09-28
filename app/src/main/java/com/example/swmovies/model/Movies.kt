package com.example.swmovies.model

import com.google.gson.annotations.SerializedName

data class Movies (
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val poster: String
    )
data class ResponseData(
    @SerializedName("results")
    val results: List<Movies>

)


