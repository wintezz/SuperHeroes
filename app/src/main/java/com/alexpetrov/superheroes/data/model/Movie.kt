package com.alexpetrov.superheroes.data.model

data class Movie(
    var name: String? = null,
    var realname: String? = null,
    var team: String? = null,
    var firstappearance: Int? = null,
    var createdby: String? = null,
    var publisher: String? = null,
    var imageurl: String? = null,
    var bio: String? = null
)