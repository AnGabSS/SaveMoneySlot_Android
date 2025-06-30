package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tech.padawan.savemoneyslot.presentation.navigation.AppNavigationController
import com.tech.padawan.savemoneyslot.ui.theme.SaveMoneySlotTheme

@Composable
fun BackgroundForPreview(
    content: @Composable (PaddingValues) -> Unit
){

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF12323D))
            ) {
                content
            }


}