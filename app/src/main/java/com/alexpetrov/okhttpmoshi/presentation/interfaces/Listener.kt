package com.alexpetrov.okhttpmoshi.presentation.interfaces

import com.alexpetrov.okhttpmoshi.data.model.HeroModel

interface Listener {
    fun onClickItem(heroModel: List<HeroModel>, position: Int)
}

