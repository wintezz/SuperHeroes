package com.alexpetrov.superheroes.data.retrofit

import com.alexpetrov.superheroes.data.model.HeroModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("/all.json")
    fun getDataAsync(): Deferred<List<HeroModel>>
}