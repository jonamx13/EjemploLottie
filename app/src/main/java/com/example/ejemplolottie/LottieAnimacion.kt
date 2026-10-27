package com.example.ejemplolottie

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import kotlinx.coroutines.launch

@Composable
fun LottieAnimacion(modifier: Modifier = Modifier) {
    // Importar el json de lottie
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.goti))

    // Controlador de la animación
    val animatable = rememberLottieAnimatable()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = { animatable.progress },
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = {
                coroutineScope.launch {
                    animatable.animate(
                        composition = composition,
                        initialProgress = animatable.progress,
                        iterations = LottieConstants.IterateForever
                    )
                }
            }) { Text("Play") }

            Button(onClick = {
                coroutineScope.launch {
                    animatable.snapTo(composition, animatable.progress)
                }
            }) { Text("Pausa") }

            Button(onClick = {
                coroutineScope.launch {
                    animatable.snapTo(composition, 0f)
                }
            }) { Text("Detener") }
        }
    }
}