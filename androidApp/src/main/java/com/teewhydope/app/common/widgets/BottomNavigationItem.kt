package com.teewhydope.app.common.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.teewhydope.app.ui.route.People
import com.teewhydope.app.ui.route.Starships


data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: Any = People
) {
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "People",
                icon = Icons.Filled.Home,
                route = People
            ),
            BottomNavigationItem(
                label = "Starships",
                icon = Icons.Filled.Star,
                route = Starships
            ),
        )
    }
}