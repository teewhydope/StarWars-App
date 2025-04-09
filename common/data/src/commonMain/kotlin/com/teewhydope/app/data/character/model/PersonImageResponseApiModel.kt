package com.teewhydope.app.data.character.model

import kotlinx.serialization.Serializable


@Serializable
data class PersonImageResponseApiModel(
    val id: Int,
    val name: String,
    val image: String
)