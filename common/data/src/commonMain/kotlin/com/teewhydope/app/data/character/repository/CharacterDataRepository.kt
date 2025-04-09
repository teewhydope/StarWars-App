package com.teewhydope.app.data.character.repository

import com.teewhydope.app.data.character.datasource.remote.CharacterRemoteSource
import com.teewhydope.app.data.common.network.extension.doOrThrowException
import com.teewhydope.app.data.character.mapper.CharacterDataToDomainExceptionMapper
import com.teewhydope.app.data.character.mapper.PeopleDataToDomainModelMapper
import com.teewhydope.app.data.character.mapper.PersonDetailDataToDomainModelMapper
import com.teewhydope.app.domain.character.model.PeopleDomainModel
import com.teewhydope.app.domain.character.model.PersonDetailDomainModel
import com.teewhydope.app.domain.character.repository.CharacterRepository

class CharacterDataRepository(
    private val characterRemoteSource: CharacterRemoteSource,
    private val personDetailDataToDomainModelMapper: PersonDetailDataToDomainModelMapper,
    private val characterDataToDomainExceptionMapper: CharacterDataToDomainExceptionMapper,

    ) : CharacterRepository {
    override suspend fun people(): PeopleDomainModel =
        doOrThrowException(
            execute = {
                val dataModel = characterRemoteSource.people()
                val enrichedResults = dataModel.results.map { person ->
                    val id = extractIdFromUrl(person.url)
                    val imageData = characterRemoteSource.personImageData(id)

                    personDetailDataToDomainModelMapper.toDomain(
                        PersonDetailDataToDomainModelMapper.MapperInput(
                            image = imageData.image,
                            model = person,
                            id = id.toInt()
                        )
                    )
                }
                PeopleDomainModel(count = dataModel.count, results = enrichedResults)
            },
            exceptionHandler = { throwable ->
                characterDataToDomainExceptionMapper.toDomain(throwable)
            }
        )

    override suspend fun personDetail(id: Int): PersonDetailDomainModel =
        doOrThrowException(
            execute = {
                val dataModel = characterRemoteSource.personDetail(id)
                val uId = extractIdFromUrl(dataModel.url)
                val imageData = characterRemoteSource.personImageData(uId)
                val mapperInput = PersonDetailDataToDomainModelMapper.MapperInput(
                    model = dataModel,
                    image = imageData.image,
                    id = uId.toInt()
                )
                personDetailDataToDomainModelMapper.toDomain(mapperInput)
            },
            exceptionHandler = { throwable ->
                characterDataToDomainExceptionMapper.toDomain(throwable)
            }
        )

    private fun extractIdFromUrl(url: String): String {
        val regex = """.*/(\d+)/""".toRegex()
        val match = regex.find(url)
        return match?.groupValues?.get(1) ?: ""
    }
}

