package com.teewhydope.app.presentation.character.model

sealed interface CharacterErrorPresentationModel {
    data object RequestTimeout : CharacterErrorPresentationModel

    data object NoInternet : CharacterErrorPresentationModel

    data object Unknown : CharacterErrorPresentationModel
}

