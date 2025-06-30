package com.tech.padawan.savemoneyslot

import androidx.compose.ui.graphics.Color
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Date
import java.util.Locale
import android.graphics.Color as AndroidColor



fun getColorByTransactionType(type: Int): Color {
    when(type){
        1 -> return Color.Red
        2 -> return Color(0XFF00FF11)
        3 -> return Color(0XFFFFD400)
    }
    return Color.Gray
}

fun parseDateToTime(date: Date): String {
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
        .withZone(ZoneId.systemDefault())

    val formattedTime = timeFormatter.format(Instant.ofEpochMilli(date.time))

    return formattedTime

}

fun formatDate(date: Date): String {
    val localDate = date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate()

    val formatter = DateTimeFormatter
        .ofLocalizedDate(FormatStyle.LONG)
        .withLocale(Locale.getDefault())

    return formatter.format(localDate)
}

fun formatDate(date: LocalDate): String {
    val formatter = DateTimeFormatter
        .ofLocalizedDate(FormatStyle.LONG)
        .withLocale(Locale.getDefault())

    return formatter.format(date)
}

fun Color.darken(factor: Float = 0.4f): Color {
    val hsv = FloatArray(3)
    val red = this.red
    val green = this.green
    val blue = this.blue

    AndroidColor.RGBToHSV((red * 255).toInt(), (green * 255).toInt(), (blue * 255).toInt(), hsv)

    hsv[2] = (hsv[2] * factor).coerceIn(0f, 1f)

    val alpha = (this.alpha * 255).toInt()
    val newColorInt = AndroidColor.HSVToColor(alpha, hsv)

    return Color(newColorInt)
}