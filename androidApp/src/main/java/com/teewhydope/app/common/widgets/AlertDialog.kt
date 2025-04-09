package com.teewhydope.app.common.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.teewhydope.app.starwars.android.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit = {},
    onConfirmAction: () -> Unit = {},
    title: String = "Alert",
    text: String,
) {
    AlertDialog(
        title = { Text(text = title) },
        text = { Text(text = text) },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmAction()
                    onDismissRequest()
                }
            ) { Text(text = stringResource(R.string.reload)) }
        }
    )
}