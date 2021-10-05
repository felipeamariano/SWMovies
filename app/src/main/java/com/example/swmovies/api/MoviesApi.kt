package com.example.swmovies.api

import com.example.swmovies.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getMoviesApi(@Query("api_key") apiKey: String): Call<ResponseData>

    @GET("movie/{id_movie}")
    fun getMovieById(@Path("id_movie") idMovie: Int): Call<ResponseData>

    @GET("movie/{id_movie}/reviews")
    fun getMovieReviewsById(@Path("id_movie") idMovie: Int): Call<ResponseData>
}