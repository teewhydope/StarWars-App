package com.teewhydope.app.di.network

import com.teewhydope.app.data.common.network.NetworkClient
import com.teewhydope.app.data.common.network.httpClientEngineConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import org.koin.dsl.module

val providedNetworkModule = module {
    includes(providesNetworkClientFactory())
    includes(providesNetworkClient())
}


fun providesNetworkClientFactory() = module {
    single<HttpClientEngineFactory<HttpClientEngineConfig>> { httpClientEngineConfig }
}

fun providesNetworkClient() = module {
    single { NetworkClient().build() }
}

