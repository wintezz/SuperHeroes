package com.alexpetrov.okhttpmoshi.data.model

data class HeroModel(
    val id: Int,
    val name: String,
    val slug: String,
    val powerstats: List<PowerStats>,
    val images: List<Images>
)