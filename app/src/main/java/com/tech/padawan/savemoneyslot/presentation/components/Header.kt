package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.R
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans

@Composable
fun Header(
        screenName: String,
        onMenuClick: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFF12323D)) // O background foi movido para cá
        .drawBehind {
            val strokeWidth = 1.dp.toPx()
            val y = size.height - strokeWidth / 2
            drawLine(
                color = Color.White,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth
            )
        }
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 10.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_menu_24),
                contentDescription = "Hamburger Menu",
                modifier = Modifier.clickable { onMenuClick() }
            )
            Text(
                text=screenName,
                color = Color.White,
                fontFamily = PixelifySans,
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "Account photo"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview(){
    Header("Home", onMenuClick = {})
}
