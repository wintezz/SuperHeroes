package com.alexpetrov.superheroes.data.retrofit

import com.alexpetrov.superheroes.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("marvel")
     fun getMovieList(): Call<MutableList<Movie>>
}