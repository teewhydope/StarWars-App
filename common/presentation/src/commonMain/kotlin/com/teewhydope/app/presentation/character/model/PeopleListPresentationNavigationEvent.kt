package com.teewhydope.app.presentation.character.model

import com.teewhydope.app.presentation.common.navigation.PresentationNavigationEvent

sealed class PeopleListPresentationNavigationEvent : PresentationNavigationEvent {

    data class OnViewDetails(val id: Int) : PeopleListPresentationNavigationEvent()
}