package com.teewhydope.app

import android.app.Application
import com.teewhydope.app.di.character.providedAppDependenciesModule
import com.teewhydope.app.di.character.providedCharacterUiModule
import com.teewhydope.app.di.character.providedResourcesModule
import com.teewhydope.app.di.initKoin
import com.teewhydope.app.di.logger.providesLoggerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class MainApplication : Application(), KoinComponent {
    //private val logger: Logger by inject()

    override fun onCreate() {
        super.onCreate()

        //_globalLogger = GlobalLogger(logger)

        initKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                //providesNavigationModule,
                providedResourcesModule,
                providedAppDependenciesModule,
                providedCharacterUiModule,
                providesLoggerModule
            )
        }
    }
}