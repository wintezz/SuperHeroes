package com.alexpetrov.okhttpmoshi.presentation.interfaces

interface DataSource<T> {
    suspend fun getData(): T
}