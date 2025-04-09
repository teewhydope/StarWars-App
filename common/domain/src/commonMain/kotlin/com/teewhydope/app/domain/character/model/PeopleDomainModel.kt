package com.teewhydope.app.domain.character.model


data class PeopleDomainModel(
    val count: Int,
    val results: List<PersonDetailDomainModel>,
)