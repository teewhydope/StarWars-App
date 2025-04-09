package com.teewhydope.app.data.character.mapper

import com.teewhydope.app.data.common.mapper.ApiToDataMapper
import com.teewhydope.app.data.character.model.PeopleDataModel
import com.teewhydope.app.data.character.model.PeopleResponseApiModel


class PeopleResponseApiToDataModelMapper(
    private val personDetailResponseApiToDataModelMapper: PersonDetailResponseApiToDataModelMapper
) : ApiToDataMapper<PeopleResponseApiModel, PeopleDataModel>() {
    override fun map(input: PeopleResponseApiModel) = PeopleDataModel(
        count = input.count,
        next = input.next,
        previous = input.previous,
        results = input.results.map { result ->
            personDetailResponseApiToDataModelMapper.toData(result)
        }
    )
}