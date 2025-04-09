package com.teewhydope.app.di.architecture

import com.teewhydope.app.presentation.common.internal.exception.GeneralDomainToPresentationExceptionMapper
import org.koin.dsl.module

val providedPresentationModule = module {
    includes(providesGeneralDomainToPresentationExceptionMapper())
}


fun providesGeneralDomainToPresentationExceptionMapper() = module {
    single { GeneralDomainToPresentationExceptionMapper() }
}
