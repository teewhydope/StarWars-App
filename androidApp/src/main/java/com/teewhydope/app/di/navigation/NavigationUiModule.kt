package com.teewhydope.app.di.navigation

import org.koin.dsl.module

val providesNavigationModule = module {
    includes(providesGlobalDestinationMapper(), providesUiDestinationMapper())
}


fun providesGlobalDestinationMapper() = module {
    //single { GlobalDestinationMapper() }
}

fun providesUiDestinationMapper() = module {
    //single { GlobalDestinationMapper() }
}