package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.R

@Composable
fun SideNavBarHeader(onMenuClick: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFF12323D))

    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.outline_close_small_24),
                contentDescription = "Hamburger Menu",
                modifier = Modifier.clickable { onMenuClick() }
            )

            Row {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "66", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.coin),
                        contentDescription = "Coin image",
                        modifier = Modifier.size(20.dp)

                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "Account photo"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SideNavBarHeaderPreview(){
    SideNavBarHeader(onMenuClick = {})
}
