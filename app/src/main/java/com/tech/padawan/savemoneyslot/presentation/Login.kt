package com.tech.padawan.savemoneyslot.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tech.padawan.savemoneyslot.R
import com.tech.padawan.savemoneyslot.presentation.navigation.Screen
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans

@Composable
fun Login(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
                modifier = Modifier
                    .width(350.dp)
                    .height(120.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
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
                            fontFamily = PixelifySans,
                            color = Color.White
                        )
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White.copy(alpha = 0.5f),
                        unfocusedContainerColor = Color.White.copy(alpha = 0.5f),
                    ),
                    placeholder = {
                        Text(
                            text = "david@bowie.com.us",
                            fontFamily = PixelifySans,
                            color = Color.White
                        )
                    }
                )
                TextField(
                    value = password,
                    onValueChange = {newValue -> password = newValue},
                    label = {
                        Text(
                            text = "Password",
                            fontFamily = PixelifySans,
                            color = Color.White
                        )
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White.copy(alpha = 0.5f),
                        unfocusedContainerColor = Color.White.copy(alpha = 0.5f),
                    )
                )
                Button(
                    onClick = {navController.navigate(Screen.Home.route)} ,
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(alpha = 0.5f)
                    )
                ) {
                    Text(
                        text = "Start",
                        fontFamily = PixelifySans,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(R.drawable.coin),
                        contentDescription = "Coin image",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    Login(rememberNavController())
}