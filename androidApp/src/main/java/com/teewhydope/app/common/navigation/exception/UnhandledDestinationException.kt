package com.teewhydope.app.common.navigation.exception

import com.teewhydope.app.presentation.common.navigation.PresentationNavigationEvent

class UnhandledDestinationException(destination: PresentationNavigationEvent) :
    IllegalArgumentException(
        "Navigation to ${destination::class.simpleName} was not handled."
    )