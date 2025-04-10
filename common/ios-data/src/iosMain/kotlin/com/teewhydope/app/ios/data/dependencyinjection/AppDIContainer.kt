package com.teewhydope.app.ios.data.dependencyinjection

import com.teewhydope.app.di.initKoin
import com.teewhydope.app.logger.GlobalLogger
import com.teewhydope.app.logger._globalLogger
import org.koin.core.component.KoinComponent

class AppDIContainer : KoinComponent {

    fun initKoinModules() {
        initKoin()
    }
}

