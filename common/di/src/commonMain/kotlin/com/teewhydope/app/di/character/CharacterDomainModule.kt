package com.teewhydope.app.di.character

import com.teewhydope.app.domain.character.usecase.GetPeopleUseCase
import com.teewhydope.app.domain.character.usecase.GetPeopleUseCaseImpl
import com.teewhydope.app.domain.character.usecase.GetPersonDetailUseCase
import com.teewhydope.app.domain.character.usecase.GetPersonDetailUseCaseImpl
import org.koin.dsl.module


val providedCharacterDomainModule = module {
    includes(
        providesGetPeopleUseCase(),
        providesGetPersonDetailUseCase(),
    )
}

fun providesGetPeopleUseCase() = module {
    single<GetPeopleUseCase> { GetPeopleUseCaseImpl(get()) }
}

fun providesGetPersonDetailUseCase() = module {
    single<GetPersonDetailUseCase> { GetPersonDetailUseCaseImpl(get()) }
}
