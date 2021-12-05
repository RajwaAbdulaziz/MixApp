package com.tuwaiq.mixapp.imdb.repo

import android.util.Log
import com.tuwaiq.mixapp.imdb.api.ImdbApi
import com.tuwaiq.mixapp.imdb.models.Movie
import com.tuwaiq.mixapp.imdb.models.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "ImdbRepo"
class ImdbRepo {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/en/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val imdbApi = retrofit.create(ImdbApi::class.java)

    suspend fun fetchMovies():List<Movie> = fetchMoviesMetaData(imdbApi.fetchMovies())

    private suspend fun fetchMoviesMetaData(imdbRequest: Call<MovieResponse>)
            :List<Movie>{

        var movies:List<Movie> = emptyList()
        val response: Response<MovieResponse> = imdbRequest.awaitResponse()
        if (response.isSuccessful){
            movies = response.body()?.moviesList ?: emptyList()
            movies = movies.filterNot {
                it.image_url.isBlank()
            }
        }else{
            Log.e(TAG , "oops ${response.errorBody()}")
        }

        return movies

    }
}