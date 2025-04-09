package com.teewhydope.app.di.character

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val providedResourcesModule = module {
    includes(providesResources())
}

fun providesResources(
) = module {
    single { androidContext().resources }
}