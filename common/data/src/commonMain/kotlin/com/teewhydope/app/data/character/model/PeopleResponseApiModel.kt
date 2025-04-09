package com.teewhydope.app.data.character.model

import kotlinx.serialization.Serializable

@Serializable
data class PeopleResponseApiModel(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<PersonDetailResponseApiModel>,
)

