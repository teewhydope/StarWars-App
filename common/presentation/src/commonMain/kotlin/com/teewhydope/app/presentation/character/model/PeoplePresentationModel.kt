package com.teewhydope.app.presentation.character.model


data class PeoplePresentationModel(
    val count: Int,
    val results: List<PersonDetailPresentationModel>,
)