package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans

@Composable
fun TextWithBgColor(text: String, bgColor: Color = Color.Red, textColor: Color = Color.White, modifier: Modifier = Modifier.fillMaxWidth()){
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(color = bgColor, shape = RoundedCornerShape(8.dp))
                .padding(4.dp)
        ){
            Text(
                text = text,
                color = Color.White,
                fontFamily = PixelifySans,
                style = TextStyle(
                    shadow = Shadow(
                        color = bgColor,
                        offset = Offset(x = 2f, y = 2f),
                        blurRadius = 1f
                    )
                )
            )
        }
    }
}