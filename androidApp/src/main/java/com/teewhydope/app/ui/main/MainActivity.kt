package com.teewhydope.app.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.teewhydope.app.common.di.BottomNavigationBarDependencies
import com.teewhydope.app.common.widgets.BottomNavigationBar
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {

    private val bottomNavigationBarDependencies: BottomNavigationBarDependencies by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                bottomNavigationBarDependencies.BottomNavigationBar()
            }
        }
    }
}