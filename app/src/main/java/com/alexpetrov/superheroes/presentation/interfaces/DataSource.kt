package com.alexpetrov.superheroes.presentation.interfaces

interface DataSource<T> {
    suspend fun getData(): T
}