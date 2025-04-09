package com.teewhydope.app.common.di

import com.teewhydope.app.ui.character.screen.PeopleScreenDependencies
import com.teewhydope.app.ui.character.screen.PersonDetailDependencies


data class BottomNavigationBarDependencies(
    val peopleScreenDependencies: PeopleScreenDependencies,
    val personDetailDependencies: PersonDetailDependencies
)