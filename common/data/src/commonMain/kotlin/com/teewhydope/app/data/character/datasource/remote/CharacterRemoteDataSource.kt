package com.teewhydope.app.data.character.datasource.remote

import com.teewhydope.app.data.character.mapper.PeopleResponseApiToDataModelMapper
import com.teewhydope.app.data.character.mapper.PersonDetailResponseApiToDataModelMapper
import com.teewhydope.app.data.character.mapper.PersonImageResponseApiToDataModelMapper
import com.teewhydope.app.data.character.model.PeopleDataModel
import com.teewhydope.app.data.character.model.PersonDetailDataModel
import com.teewhydope.app.data.character.model.PersonImageDataModel

class CharacterRemoteDataSource(
    private val characterService: CharacterService,
    private val peopleResponseApiToDataModelMapper: PeopleResponseApiToDataModelMapper,
    private val personDetailResponseApiToDataModelMapper: PersonDetailResponseApiToDataModelMapper,
    private val personImageResponseApiToDataModelMapper: PersonImageResponseApiToDataModelMapper

) : CharacterRemoteSource {
    override suspend fun people(): PeopleDataModel {
        val apiModel = characterService.people()
        return peopleResponseApiToDataModelMapper.toData(apiModel)

    }

    override suspend fun personDetail(id: Int): PersonDetailDataModel {
        val apiModel = characterService.personDetail(id)
        return personDetailResponseApiToDataModelMapper.toData(apiModel)
    }

    override suspend fun personImageData(id: String): PersonImageDataModel {
        val apiModel = characterService.personImageData(id)
        return personImageResponseApiToDataModelMapper.toData(apiModel)
    }
}