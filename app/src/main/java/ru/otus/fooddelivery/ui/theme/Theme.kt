package ru.otus.fooddelivery.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = colorBlack,
    primaryVariant = colorBlackVariant,
    secondary = colorGray
)

private val LightColorPalette = lightColors(
    primary = colorBlack,
    primaryVariant = colorBlackVariant,
    secondary = colorGray,
    background = Color(0xFFF6F7FC),
)

@Composable
fun FoodDeliveryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}