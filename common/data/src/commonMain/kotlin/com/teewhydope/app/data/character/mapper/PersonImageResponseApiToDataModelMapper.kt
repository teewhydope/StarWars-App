package com.teewhydope.app.data.character.mapper

import com.teewhydope.app.data.common.mapper.ApiToDataMapper
import com.teewhydope.app.data.character.model.PersonImageDataModel
import com.teewhydope.app.data.character.model.PersonImageResponseApiModel


class PersonImageResponseApiToDataModelMapper :
    ApiToDataMapper<PersonImageResponseApiModel, PersonImageDataModel>() {
    override fun map(input: PersonImageResponseApiModel) = PersonImageDataModel(
        id = input.id,
        name = input.name,
        image = input.image,
    )
}