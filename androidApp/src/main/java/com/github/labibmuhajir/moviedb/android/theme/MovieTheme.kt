package com.github.labibmuhajir.moviedb.android.theme

import android.graphics.ColorSpace
import android.view.Window
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.toArgb
import com.github.labibmuhajir.moviedb.theme.AppColors

fun Color.Companion.parse(colorString: String): Color =
    Color(color = android.graphics.Color.parseColor(colorString))

val primaryColor = Color.parse(AppColors.primaryColor)
val secondaryColor = Color.parse(AppColors.secondaryColor)
val onPrimaryColor = Color.parse(AppColors.onPrimaryColor)
val onSecondaryColor = Color.parse(AppColors.onSecondaryColor)
val backgroundColor = primaryColor
val onBackgroundColor = onPrimaryColor
val errorColor = Color.parse(AppColors.errorColor)

private val movieColor = Colors(
    primary = primaryColor,
    secondary = secondaryColor,
    background = backgroundColor,
    onPrimary = onPrimaryColor,
    onSecondary = onSecondaryColor,
    onBackground = onBackgroundColor,
    error = errorColor,
    onError = onSecondaryColor,
    primaryVariant = primaryColor,
    secondaryVariant = secondaryColor,
    isLight = false,
    onSurface = onPrimaryColor,
    surface = primaryColor,
)

@Composable
fun MovieTheme(window: Window, content: @Composable() () -> Unit) {
    window.statusBarColor = secondaryColor.toArgb()
    MaterialTheme(
        colors = movieColor,
        content = content
    )
}