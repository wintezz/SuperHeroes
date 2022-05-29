package com.alexpetrov.superheroes.presentation.interfaces

import com.alexpetrov.superheroes.data.model.Movie

interface Listener {
    fun onClickItem(movie: MutableList<Movie>, position: Int)
}

