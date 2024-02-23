package com.local.archexample.ui.screens.main

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.local.archexample.data.models.ImageData

@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val state = viewModel.state.collectAsState()
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (state.value.isLoading) {
                true -> {
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
                    MainScreenContent(null)
                }

                false -> {
                    if (state.value.error != null) {
                        Toast.makeText(LocalContext.current, state.value.error, Toast.LENGTH_LONG)
                            .show()
                        MainScreenContent(null)
                    } else {
                        MainScreenContent(data = state.value.data)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { viewModel.floof() }) {
                Text("Refresh")
            }
        }
    }
}

@Composable
fun MainScreenContent(data: ImageData?) {
    AsyncImage(
        data?.image,
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}