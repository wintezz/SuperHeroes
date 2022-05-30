package com.alexpetrov.superheroes.domain

import com.alexpetrov.superheroes.data.model.Movie

interface Listener {
    fun onClickItem(movie: MutableList<Movie>, position: Int)
}

