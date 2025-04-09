package com.teewhydope.app.common.notification.mapper

import com.teewhydope.app.common.notification.model.UiNotification
import com.teewhydope.app.presentation.common.notification.PresentationNotification

interface NotificationUiMapper<in PRESENTATION_NOTIFICATION : PresentationNotification> {
    fun toUi(notification: PRESENTATION_NOTIFICATION): UiNotification
}