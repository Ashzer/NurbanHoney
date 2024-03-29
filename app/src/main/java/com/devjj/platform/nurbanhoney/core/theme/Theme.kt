package com.devjj.platform.nurbanhoney.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.LightGray,
    primaryVariant = Color.DarkGray,
    secondary = Color.Magenta,
    background = Color(0xFFE5E5E5)
)

private val LightColorPalette = lightColors(
    primary = Color(0xFFFFFFFF),
    primaryVariant = Color.Green,
    secondary = Color.Blue,
    // background = Color(0xFFFFFFFF),
    onBackground = Color.Red
    // surface = Color.Red
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NurbanHoneyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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
