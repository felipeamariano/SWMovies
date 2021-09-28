package com.example.swmovies.api

import com.example.swmovies.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getMovieApi(@Query("api_key") apiKey: String): Call<ResponseData>

}