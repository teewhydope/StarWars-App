package com.teewhydope.app.di.character


import com.teewhydope.app.common.navigation.mapper.NavigationEventDestinationMapper
import com.teewhydope.app.common.notification.mapper.NotificationUiMapper
import com.teewhydope.app.presentation.character.model.PeopleListPresentationNavigationEvent
import com.teewhydope.app.presentation.common.notification.PresentationNotification
import com.teewhydope.app.ui.character.mapper.PeopleListErrorPresentationToUiExceptionMapper
import com.teewhydope.app.ui.character.mapper.PeopleListNavigationEventDestinationMapper
import com.teewhydope.app.ui.character.mapper.PeopleListViewStatePresentationToUiMapper
import com.teewhydope.app.ui.character.mapper.PeoplePresentationToUiModelMapper
import com.teewhydope.app.ui.character.mapper.PersonDetailErrorPresentationToUiExceptionMapper
import com.teewhydope.app.ui.character.mapper.PersonDetailPresentationToUiModelMapper
import com.teewhydope.app.ui.character.mapper.PersonDetailViewStatePresentationToUiMapper
import com.teewhydope.app.ui.character.screen.PeopleScreenDependencies
import com.teewhydope.app.ui.character.screen.PersonDetailDependencies

import org.koin.dsl.module

private typealias NavigationMapper = NavigationEventDestinationMapper<PeopleListPresentationNavigationEvent>

private typealias NotificationMapper = NotificationUiMapper<PresentationNotification>


val providedCharacterUiModule = module {
    includes(
        providesPeopleScreenDependencies(),
        providesPersonDetailDependencies(),
        providesPeopleDomainToPresentationModelMapper(),
        providesPeopleListNavigationEventDestinationMapper(),
        providesPeoplePresentationToUiModelMapper(),
        providesPersonDetailPresentationToUiModelMapper(),
        providesCharacterErrorPresentationToUiExceptionMapper(),
        providesPeopleListViewStatePresentationToUiMapper(),
        providesPersonDetailViewStatePresentationToUiMapper(),
        providesPersonDetailErrorPresentationToUiExceptionMapper(),
    )
}


fun providesPeopleScreenDependencies(
) = module { single { PeopleScreenDependencies(get(), get(), get(), get(), get()) } }


fun providesPersonDetailDependencies(
) = module { single { PersonDetailDependencies(get(), get(), get(), get(), get()) } }

fun providesPeopleListNavigationEventDestinationMapper() = module {
    single<NavigationMapper> { PeopleListNavigationEventDestinationMapper() }
}

fun providesPeoplePresentationToUiModelMapper(
) = module {
    single { PeoplePresentationToUiModelMapper(get()) }
}


fun providesPersonDetailPresentationToUiModelMapper(
) = module {
    single { PersonDetailPresentationToUiModelMapper() }
}

fun providesCharacterErrorPresentationToUiExceptionMapper(
) = module {
    single { PeopleListErrorPresentationToUiExceptionMapper(get()) }
}

fun providesPersonDetailErrorPresentationToUiExceptionMapper(
) = module {
    single { PersonDetailErrorPresentationToUiExceptionMapper(get()) }
}


fun providesPeopleListViewStatePresentationToUiMapper(
) = module {
    single { PeopleListViewStatePresentationToUiMapper() }
}

fun providesPersonDetailViewStatePresentationToUiMapper(
) = module {
    single { PersonDetailViewStatePresentationToUiMapper() }
}















