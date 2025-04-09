package com.teewhydope.app.presentation.character.mapper

import com.teewhydope.app.domain.character.model.PeopleDomainModel
import com.teewhydope.app.presentation.character.model.PeoplePresentationModel
import com.teewhydope.app.presentation.common.mapper.DomainToPresentationMapper


class PeopleDomainToPresentationModelMapper(
    private val personDetailDomainToPresentationModelMapper: PersonDetailDomainToPresentationModelMapper
) : DomainToPresentationMapper<PeopleDomainModel, PeoplePresentationModel>() {
    override fun map(input: PeopleDomainModel) = PeoplePresentationModel(
        count = input.count,
        results = input.results.map { result ->
            personDetailDomainToPresentationModelMapper.toPresentation(result)
        }
    )
}