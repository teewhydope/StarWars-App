package com.teewhydope.app.ui.character.mapper

import com.teewhydope.app.common.mapper.PresentationToUiMapper
import com.teewhydope.app.presentation.character.viewmodel.PersonDetailViewState
import com.teewhydope.app.ui.character.model.PersonDetailUiModel


class PersonDetailPresentationToUiModelMapper :
    PresentationToUiMapper<PersonDetailViewState.Loaded, PersonDetailUiModel>() {
    override fun map(input: PersonDetailViewState.Loaded) = PersonDetailUiModel(
        id = input.personDetail.id,
        name = input.personDetail.name,
        height = input.personDetail.height,
        mass = input.personDetail.mass,
        image = input.personDetail.image,
        birthYear = input.personDetail.birthYear,
        gender = input.personDetail.gender,
        homeWorld = input.personDetail.homeWorld,
        url = input.personDetail.url,
    )
}