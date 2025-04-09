package com.teewhydope.app.ui.character.mapper

import com.teewhydope.app.common.mapper.PresentationToUiMapper
import com.teewhydope.app.presentation.character.viewmodel.PeopleListViewState
import com.teewhydope.app.presentation.character.viewmodel.PersonDetailViewState
import com.teewhydope.app.presentation.character.viewmodel.PersonDetailViewState.Loaded
import com.teewhydope.app.presentation.common.mapper.DomainToPresentationMapper
import com.teewhydope.app.ui.character.model.PeopleUiModel


class PeoplePresentationToUiModelMapper(
    private val personDetailPresentationToUiModelMapper: PersonDetailPresentationToUiModelMapper
) : PresentationToUiMapper<PeopleListViewState.Loaded, PeopleUiModel>() {
    override fun map(input: PeopleListViewState.Loaded) = PeopleUiModel(
        count = input.people.count,
        results = input.people.results.map { result ->
            personDetailPresentationToUiModelMapper.toUi(Loaded(result))
        }
    )
}