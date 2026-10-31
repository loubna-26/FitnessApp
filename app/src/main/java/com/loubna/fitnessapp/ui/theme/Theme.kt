package com.loubna.fitnessapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val FitnessColorScheme = lightColorScheme(
    primary = VerdeDeporte,
    onPrimary = Color.White,
    primaryContainer = VerdeClaro,
    onPrimaryContainer = GrisOscuro,
    secondary = NaranjaEnergia,
    onSecondary = Color.White,
    background = FondoPantalla,
    onBackground = GrisOscuro,
    surface = VerdeClaro,
    onSurface = GrisOscuro,
    surfaceVariant = VerdeClaro,
    onSurfaceVariant = GrisOscuro
)

@Composable
fun FitnessAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = FitnessColorScheme,
        typography = Typography,
        content = content
    )
}