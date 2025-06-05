package com.tech.padawan.savemoneyslot.presentation

import IntroScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.R
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans

@Composable
fun LoginScreen() {
    var email: String = "";
    var password: String = "";
    Box(
        contentAlignment = Alignment.Center,

        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF12323D))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "SaveMoneySlot logo",
                modifier = Modifier.width(350.dp).height(120.dp)
            )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextField(
                    value = email,
                    onValueChange = {newValue -> email = newValue},
                    label = {
                        Text(
                            text = "Email",
                            fontFamily = PixelifySans
                        )
                    }
                )
                TextField(
                    value = password,
                    onValueChange = {newValue -> password = newValue},
                    label = {
                        Text(
                            text = "Password",
                            fontFamily = PixelifySans
                        )
                    }
                )
                Button(
                    onClick = {},
                ) {
                    Text(
                        text = "Start",
                        fontFamily = PixelifySans
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IntroScreenPreview() {
    LoginScreen()
}