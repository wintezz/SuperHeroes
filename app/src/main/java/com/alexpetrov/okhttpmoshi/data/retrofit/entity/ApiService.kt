package com.alexpetrov.okhttpmoshi.data.retrofit.entity

import com.alexpetrov.okhttpmoshi.data.model.HeroModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("/all.json")
    fun getDataAsync(): Deferred<List<HeroModel>>
}