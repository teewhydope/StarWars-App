package com.teewhydope.app.presentation.character.viewmodel

import com.teewhydope.app.presentation.character.model.CharacterErrorPresentationModel
import com.teewhydope.app.presentation.character.model.PersonDetailPresentationModel


sealed interface PersonDetailViewState {

    data object Loading : PersonDetailViewState

    data class Loaded(
        val personDetail: PersonDetailPresentationModel = PersonDetailPresentationModel(
            id = -1,
            name = "",
            height = "",
            mass = "",
            image = "",
            birthYear = "",
            gender = "",
            homeWorld = "",
            url = "",
        ),
    ) : PersonDetailViewState

    data object Unset : PersonDetailViewState

    data class Error(val error: CharacterErrorPresentationModel) :
        PersonDetailViewState
}

