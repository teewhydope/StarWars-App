package com.teewhydope.app.presentation.character.model


sealed class PeopleListPresentationModel {
    data object Loaded : PeopleListPresentationModel()
    data class Error(val error: String) : PeopleListPresentationModel()
    data object Unset : PeopleListPresentationModel()
}
