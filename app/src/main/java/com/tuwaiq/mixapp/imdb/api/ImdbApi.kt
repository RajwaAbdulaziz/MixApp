package com.tuwaiq.mixapp.imdb.api

import com.tuwaiq.mixapp.imdb.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImdbApi {

    @GET("/API/Top250Movies/k_t59f7lo5")
    fun fetchMovies(): Call<MovieResponse>
}