package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans

@Composable
fun TransactionListCard(text: String, value: String, color: Color = Color.Red) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0x57FFFFFF), shape = RoundedCornerShape(4.dp))
            .padding(10.dp)
    ) {
        Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.CenterStart) {
            Text(
                text = text,
                color = Color.White,
                fontFamily = PixelifySans
            )
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            GlowingDot(glowColor = color)
        }

        Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
            TextWithBgColor(
                text = value,
                modifier = Modifier.width(90.dp),
                bgColor = color
            )
        }
    }
}
