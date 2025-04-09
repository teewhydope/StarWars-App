package com.teewhydope.app.data.character.model


data class PeopleDataModel(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<PersonDetailDataModel>,
)

