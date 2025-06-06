package com.tech.padawan.savemoneyslot.presentation.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tech.padawan.savemoneyslot.presentation.IntroScreen
import com.tech.padawan.savemoneyslot.presentation.LoginScreen

enum class Screen {
    Intro,
    Login
}

@Composable
fun AppNavigationController() {
    var currentScreen by remember { mutableStateOf(Screen.Intro) }

    AnimatedContent(
        targetState = currentScreen,
        transitionSpec = {
            fadeIn(
                animationSpec = tween(750)
            ) togetherWith fadeOut(animationSpec = tween(750))
        },
        label = "Screen Crossfade"
    ) { screen ->
        when (screen) {
            Screen.Intro -> {
                IntroScreen(
                    onAnimationFinished = {
                        currentScreen = Screen.Login
                    }
                )
            }
            Screen.Login -> {
                LoginScreen()
            }
        }
    }
}