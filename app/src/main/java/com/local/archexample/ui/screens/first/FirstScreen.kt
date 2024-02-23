package com.local.archexample.ui.screens.first

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.local.archexample.data.models.ImageData

@Composable
fun FirstScreen() {
    val viewModel = hiltViewModel<FirstScreenViewModel>()
    val state = viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        when (state.value.isLoading) {
            true -> {
                FirstScreenContent(null)
            }

            false -> {
                if (state.value.error != null) {
                    Toast.makeText(LocalContext.current, state.value.error, Toast.LENGTH_LONG)
                        .show()
                    FirstScreenContent(null)
                } else {
                    FirstScreenContent(data = state.value.data)
                }
            }
        }
        Button(onClick = { viewModel.floof() }) {
            Text("Refresh")
        }
    }
}

@Composable
fun FirstScreenContent(data: ImageData?) {
    Surface {
        AsyncImage(
            data?.image,
            contentDescription = null,
            modifier = Modifier.size(256.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}