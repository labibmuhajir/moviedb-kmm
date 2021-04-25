package com.github.labibmuhajir.moviedb.android.theme

import android.view.Window
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.github.labibmuhajir.moviedb.theme.AppColors

val primaryColor = Color(AppColors.primaryColor)
val secondaryColor = Color(AppColors.secondaryColor)
val onPrimaryColor = Color(AppColors.onPrimaryColor)
val onSecondaryColor = Color(AppColors.onSecondaryColor)
val backgroundColor = primaryColor
val onBackgroundColor = onPrimaryColor
val errorColor = Color(AppColors.errorColor)

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
fun MovieTheme(window:Window, content: @Composable() () -> Unit) {
    window.statusBarColor = secondaryColor.toArgb()
    MaterialTheme(
        colors = movieColor,
        content = content
    )
}