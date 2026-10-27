package com.example.ejemplolottie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ejemplolottie.ui.theme.EjemploLottieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploLottieTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Aquí metemos el composable
                    LottieAnimacion(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}