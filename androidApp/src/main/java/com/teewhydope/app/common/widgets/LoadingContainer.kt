package com.teewhydope.app.common.widgets

import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CircularProgressIndicator

@Composable
fun LoadingContainer(
    visible: Boolean,
    modifier: Modifier = Modifier
) {
    if (visible) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(40.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }

}
