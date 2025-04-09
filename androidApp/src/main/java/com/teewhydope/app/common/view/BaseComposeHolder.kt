package com.teewhydope.app.common.view


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.teewhydope.app.common.navigation.mapper.NavigationEventDestinationMapper
import com.teewhydope.app.common.notification.mapper.NotificationUiMapper
import com.teewhydope.app.presentation.common.navigation.PresentationNavigationEvent
import com.teewhydope.app.presentation.common.notification.PresentationNotification
import com.teewhydope.app.presentation.common.viewmodel.BaseViewModel


abstract class BaseComposeHolder<VIEW_STATE : Any, NOTIFICATION : PresentationNotification>(
    private val viewModel: BaseViewModel<VIEW_STATE, NOTIFICATION>,
    private val navigationMapper: NavigationEventDestinationMapper<*>?,
    private val notificationMapper: NotificationUiMapper<NOTIFICATION>?
) {

    @Composable
    fun ViewModelObserver(navController: NavController) {
        viewModel.notification.collectAsState(initial = null)
            .value?.let { notificationValue ->
                Notifier(notification = notificationValue)
            }

        viewModel.navigationEvent.collectAsState(initial = null)
            .value?.let { navigationValue ->
                Navigator(navigationValue, navController)
            }
    }


    @Composable
    private fun Notifier(notification: NOTIFICATION) {
        LaunchedEffect(notification) {
            notificationMapper?.toUi(notification)?.present()
        }
    }

    @Composable
    private fun Navigator(navigation: PresentationNavigationEvent, navController: NavController) {
        LaunchedEffect(navigation) {
            navigationMapper?.toUi(navigation)?.navigate(navController)
        }
    }
}