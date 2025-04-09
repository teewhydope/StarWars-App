package com.teewhydope.app.data.character.mapper

import com.teewhydope.app.data.common.mapper.DataToDomainMapper
import com.teewhydope.app.data.character.mapper.PeopleDataToDomainModelMapper.MapperInput
import com.teewhydope.app.data.character.model.PeopleDataModel
import com.teewhydope.app.domain.character.model.PeopleDomainModel

class PeopleDataToDomainModelMapper(
    private val personDetailDataToDomainModelMapper: PersonDetailDataToDomainModelMapper
) : DataToDomainMapper<MapperInput, PeopleDomainModel>() {
    override fun map(input: MapperInput) = PeopleDomainModel(
        count = input.peopleDataModel.count,
        results = input.peopleDataModel.results.map { result ->
            personDetailDataToDomainModelMapper.toDomain(
                PersonDetailDataToDomainModelMapper.MapperInput(
                    image = input.image,
                    model = result,
                    id = input.id
                )
            )
        }
    )

    data class MapperInput(
        val peopleDataModel: PeopleDataModel,
        val image: String,
        val id: Int,
    )
}