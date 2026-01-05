package com.example.gopadditestapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R


val satoshiFontFamily = FontFamily(

    Font(R.font.satoshi_light, FontWeight.Light),
    Font(R.font.satoshi_regular, FontWeight.Normal),
    Font(R.font.satoshi_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.satoshi_medium, FontWeight.Medium),
    Font(R.font.satoshi_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

// Set of Material typography styles to start with
val SatoshiTypography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        textMotion = TextMotion.Animated,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontSize = 57.sp,
        lineHeight = 64.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    displayMedium = TextStyle(
        fontSize = 45.sp,
        lineHeight = 52.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    displaySmall = TextStyle(
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    headlineSmall = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.W900,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    labelSmall = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        textMotion = TextMotion.Animated,
    ),
)
