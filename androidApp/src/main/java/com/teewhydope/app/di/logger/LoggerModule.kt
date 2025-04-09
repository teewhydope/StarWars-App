package com.teewhydope.app.di.logger

import org.koin.dsl.module
import com.teewhydope.app.logger.PlatformLogger

val providesLoggerModule = module {
    includes(providesPlatformLogger())
}


fun providesPlatformLogger() = module {
    single { PlatformLogger() }
}