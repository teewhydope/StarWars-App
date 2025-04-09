package com.teewhydope.app.presentation.character.model


data class PersonDetailPresentationModel(
    val id: Int,
    val name: String,
    val height: String,
    val mass: String,
    val image: String,
    val birthYear: String,
    val gender: String,
    val homeWorld: String,
    val url: String,
)