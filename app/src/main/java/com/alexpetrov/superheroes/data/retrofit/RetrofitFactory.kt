package com.alexpetrov.superheroes.data.retrofit

import android.app.Application
import com.alexpetrov.superheroes.presentation.interfaces.DataSource
import com.alexpetrov.superheroes.data.model.HeroModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory : Application(), DataSource<List<HeroModel>> {

    override fun onCreate() {
        super.onCreate()

        createRetrofit()
        getService()
    }

    override suspend fun getData(): List<HeroModel> {
        return getService().getDataAsync().await()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    private fun getService(): ApiService {
        return createRetrofit().create(ApiService::class.java)
    }

    companion object {
        private const val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"
    }
}