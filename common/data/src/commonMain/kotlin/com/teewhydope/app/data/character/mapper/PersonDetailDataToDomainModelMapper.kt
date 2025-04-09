package com.teewhydope.app.data.character.mapper

import com.teewhydope.app.data.common.mapper.DataToDomainMapper
import com.teewhydope.app.data.character.model.PersonDetailDataModel
import com.teewhydope.app.domain.character.model.PersonDetailDomainModel


class PersonDetailDataToDomainModelMapper :
    DataToDomainMapper<PersonDetailDataToDomainModelMapper.MapperInput, PersonDetailDomainModel>() {
    override fun map(input: MapperInput) =
        PersonDetailDomainModel(
            id = input.id,
            name = input.model.name,
            height = input.model.height,
            mass = input.model.mass,
            image = input.image,
            birthYear = input.model.birthYear,
            gender = input.model.gender,
            homeWorld = input.model.homeWorld,
            url = input.model.url,
        )


    data class MapperInput(
        val model: PersonDetailDataModel,
        val image: String,
        val id: Int,
    )
}