package com.teewhydope.app.common.navigation.mapper


import com.teewhydope.app.common.navigation.exception.UnhandledDestinationException
import com.teewhydope.app.common.navigation.model.UiDestination
import com.teewhydope.app.presentation.common.navigation.PresentationNavigationEvent
import kotlin.reflect.KClass

abstract class NavigationEventDestinationMapper<in EVENT : PresentationNavigationEvent>(
    private val kotlinClass: KClass<EVENT>
) {
    fun toUi(navigationEvent: PresentationNavigationEvent): UiDestination = when {
        kotlinClass.isInstance(navigationEvent) -> {
            @Suppress("UNCHECKED_CAST")
            mapTypedEvent(navigationEvent as EVENT)
        }

        else -> {
            mapGenericEvent(navigationEvent) ?: throw UnhandledDestinationException(
                navigationEvent
            )
        }
    }

    protected abstract fun mapTypedEvent(navigationEvent: EVENT): UiDestination

    protected open fun mapGenericEvent(
        navigationEvent: PresentationNavigationEvent
    ): UiDestination? = null
}