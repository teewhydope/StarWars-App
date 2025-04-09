package com.teewhydope.app.data.character.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonDetailResponseApiModel(
    val name: String,
    val height: String,
    val mass: String,
    @SerialName("hair_color")
    val hairColor: String,
    @SerialName("skin_color")
    val skinColor: String,
    @SerialName("eye_color")
    val eyeColor: String,
    @SerialName("birth_year")
    val birthYear: String,
    val gender: String,
    @SerialName("homeworld")
    val homeWorld: String,
    val films: List<String>,
    val vehicles: List<String>,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String,
)

