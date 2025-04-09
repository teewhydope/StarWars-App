package com.teewhydope.app.presentation.character.viewmodel

import com.teewhydope.app.presentation.character.mapper.CharacterErrorDomainToPresentationExceptionMapper
import com.teewhydope.app.presentation.character.model.CharacterErrorPresentationModel
import com.teewhydope.app.presentation.character.model.PeoplePresentationModel


sealed interface PeopleListViewState {


    data object Loading : PeopleListViewState

    data class Loaded(
        val people: PeoplePresentationModel = PeoplePresentationModel(
            count = 0,
            results = emptyList()
        ),
    ) : PeopleListViewState

    data object Unset : PeopleListViewState

    data class Error(val error: CharacterErrorPresentationModel) :
        PeopleListViewState
}

