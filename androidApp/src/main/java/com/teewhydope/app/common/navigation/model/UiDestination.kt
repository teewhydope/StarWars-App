package com.teewhydope.app.common.navigation.model

import androidx.navigation.NavController

fun interface UiDestination {
    fun navigate(navController: NavController)
}