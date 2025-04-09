package com.teewhydope.app.presentation.character.mapper

import com.teewhydope.app.domain.character.model.PersonDetailDomainModel
import com.teewhydope.app.presentation.character.model.PersonDetailPresentationModel
import com.teewhydope.app.presentation.common.mapper.DomainToPresentationMapper


class PersonDetailDomainToPresentationModelMapper :
    DomainToPresentationMapper<PersonDetailDomainModel, PersonDetailPresentationModel>() {
    override fun map(input: PersonDetailDomainModel) = PersonDetailPresentationModel(
        id = input.id,
        name = input.name,
        height = input.height,
        mass = input.mass,
        image = input.image,
        birthYear = input.birthYear,
        gender = input.gender,
        homeWorld = input.homeWorld,
        url = input.url,
    )
}