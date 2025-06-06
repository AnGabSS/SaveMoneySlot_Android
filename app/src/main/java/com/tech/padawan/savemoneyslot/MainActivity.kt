package com.tech.padawan.savemoneyslot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box // Importar Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding // Importar padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tech.padawan.savemoneyslot.presentation.navigation.AppNavigationController

import com.tech.padawan.savemoneyslot.ui.theme.SaveMoneySlotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaveMoneySlotTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFF12323D))
                ) { innerPadding ->

                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigationController()
                    }
                }
            }
        }
    }
}