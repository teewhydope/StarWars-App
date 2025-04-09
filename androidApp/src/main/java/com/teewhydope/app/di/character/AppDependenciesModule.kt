package com.teewhydope.app.di.character

import com.teewhydope.app.common.di.BottomNavigationBarDependencies


import org.koin.dsl.module

val providedAppDependenciesModule = module {
    includes(providesBottomNavigationBarDependencies())
}

fun providesBottomNavigationBarDependencies(
) = module {
    single { BottomNavigationBarDependencies(get(), get()) }
}


