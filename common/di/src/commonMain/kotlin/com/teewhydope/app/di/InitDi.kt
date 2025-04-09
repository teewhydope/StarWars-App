package com.teewhydope.app.di

import com.teewhydope.app.di.architecture.providedPresentationModule
import com.teewhydope.app.di.character.providedCharacterDataModule
import com.teewhydope.app.di.character.providedCharacterDomainModule
import com.teewhydope.app.di.character.providedCharacterPresentationModule
import com.teewhydope.app.di.network.providedNetworkModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration


fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            providedNetworkModule,
            providedPresentationModule,
            providedCharacterDataModule,
            providedCharacterDomainModule,
            providedCharacterPresentationModule,
        )
    }
