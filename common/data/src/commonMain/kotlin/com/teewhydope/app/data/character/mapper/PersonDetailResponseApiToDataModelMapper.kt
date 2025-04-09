package com.teewhydope.app.data.character.mapper

import com.teewhydope.app.data.common.mapper.ApiToDataMapper
import com.teewhydope.app.data.character.model.PersonDetailDataModel
import com.teewhydope.app.data.character.model.PersonDetailResponseApiModel


class PersonDetailResponseApiToDataModelMapper :
    ApiToDataMapper<PersonDetailResponseApiModel, PersonDetailDataModel>() {
    override fun map(input: PersonDetailResponseApiModel) = PersonDetailDataModel(
        name = input.name,
        height = input.height,
        mass = input.mass,
        hairColor = input.hairColor,
        skinColor = input.skinColor,
        eyeColor = input.eyeColor,
        birthYear = input.birthYear,
        gender = input.gender,
        homeWorld = input.homeWorld,
        films = input.films,
        vehicles = input.vehicles,
        starships = input.starships,
        created = input.created,
        edited = input.edited,
        url = input.url,
    )
}