package com.tech.padawan.savemoneyslot.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tech.padawan.savemoneyslot.R

val PixelifySans = FontFamily(
    Font(R.font.pixelifysans_regular, FontWeight.Normal),
    Font(R.font.pixelifysans_medium, FontWeight.Medium),
    Font(R.font.pixelifysans_semibold, FontWeight.SemiBold),
    Font(R.font.pixelifysans_bold, FontWeight.Bold)
)


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = PixelifySans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    titleLarge = TextStyle(
        fontFamily = PixelifySans,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = Color.White
    ),
    titleMedium = TextStyle(
        fontFamily = PixelifySans,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    titleSmall = TextStyle(
        fontFamily = PixelifySans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    labelSmall = TextStyle(
        fontFamily = PixelifySans,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    bodySmall = TextStyle(
        fontFamily = PixelifySans,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),


)
