package com.alexpetrov.superheroes.presentation.interfaces

import com.alexpetrov.superheroes.data.model.HeroModel

interface Listener {
    fun onClickItem(heroModel: List<HeroModel>, position: Int)
}

