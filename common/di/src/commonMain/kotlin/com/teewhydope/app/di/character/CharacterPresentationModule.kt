package com.teewhydope.app.di.character

import com.teewhydope.app.presentation.character.mapper.CharacterErrorDomainToPresentationExceptionMapper
import com.teewhydope.app.presentation.character.mapper.PeopleDomainToPresentationModelMapper
import com.teewhydope.app.presentation.character.mapper.PersonDetailDomainToPresentationModelMapper
import org.koin.compose.viewmodel.dsl.viewModelOf
import com.teewhydope.app.presentation.character.viewmodel.PeopleListViewModel
import com.teewhydope.app.presentation.character.viewmodel.PersonDetailViewModel

import org.koin.dsl.module

val providedCharacterPresentationModule = module {
    includes(
        providesPeopleListViewModel(),
        providesPeopleDomainToPresentationModelMapper(),
        providesPersonDetailDomainToPresentationModelMapper(),
        providesCharacterErrorDomainToPresentationExceptionMapper(),
        providesPersonDetailViewModel()
    )
}

fun providesPeopleListViewModel(
) = module { viewModelOf(::PeopleListViewModel) }

fun providesPersonDetailViewModel(
) = module { viewModelOf(::PersonDetailViewModel) }


fun providesPeopleDomainToPresentationModelMapper() = module {
    single { PeopleDomainToPresentationModelMapper(get()) }
}


fun providesPersonDetailDomainToPresentationModelMapper() = module {
    single { PersonDetailDomainToPresentationModelMapper() }
}

fun providesCharacterErrorDomainToPresentationExceptionMapper() = module {
    single { CharacterErrorDomainToPresentationExceptionMapper() }
}

