package com.tech.padawan.savemoneyslot

import androidx.compose.ui.graphics.Color


fun getColorByTransactionType(type: Int): Color {
    when(type){
        1 -> return Color.Red
        2 -> return Color(0XFF00FF11)
        3 -> return Color(0XFFFFD400)
    }
    return Color.Gray
}

