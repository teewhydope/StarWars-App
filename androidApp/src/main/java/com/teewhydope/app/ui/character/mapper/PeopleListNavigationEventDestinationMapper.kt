package com.teewhydope.app.ui.character.mapper


import com.teewhydope.app.common.navigation.mapper.NavigationEventDestinationMapper
import com.teewhydope.app.common.navigation.model.UiDestination
import com.teewhydope.app.presentation.character.model.PeopleListPresentationNavigationEvent
import com.teewhydope.app.presentation.character.model.PeopleListPresentationNavigationEvent.OnViewDetails
import com.teewhydope.app.ui.route.PersonDetail

class PeopleListNavigationEventDestinationMapper :
    NavigationEventDestinationMapper<PeopleListPresentationNavigationEvent>(
        PeopleListPresentationNavigationEvent::class
    ) {
    override fun mapTypedEvent(navigationEvent: PeopleListPresentationNavigationEvent): UiDestination =
        when (navigationEvent) {
            is OnViewDetails -> detail(navigationEvent.id)
        }

    private fun detail(id: Int): UiDestination =
        UiDestination { navController -> navController.navigate(PersonDetail(id)) }

}