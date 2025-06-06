package com.tech.padawan.savemoneyslot.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInCubic
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun IntroScreen(onAnimationFinished: () -> Unit) {
    val coinSize = 70.dp

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    val firstImpactTargetX = -(screenWidthDp.value / 4f)
    val initialCoinX = -(screenWidthDp.value / 1.8f)
    val initialCoinY = -450f

    val coinOffsetX = remember { Animatable(initialCoinX) }
    val coinOffsetY = remember { Animatable(initialCoinY) }
    val coinScale = remember { Animatable(1f) }
    val coinAlpha = remember { Animatable(0f) }

    val logoAlpha = remember { Animatable(0f) }
    val logoRevealFraction = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        coinAlpha.animateTo(1f, animationSpec = tween(durationMillis = 200))
        launch {
            coinOffsetX.animateTo(
                targetValue = firstImpactTargetX,
                animationSpec = tween(durationMillis = 750, easing = LinearEasing)
            )
        }
        coinOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 750, easing = EaseInCubic)
        )

        val jumpDuration = 700
        val jumpPeakVertical = -90f

        launch {
            coinOffsetX.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = jumpDuration, easing = EaseInOutQuad)
            )
        }
        launch {
            coinOffsetY.animateTo(
                targetValue = jumpPeakVertical,
                animationSpec = tween(durationMillis = jumpDuration / 3, easing = EaseOutCubic)
            )
            coinOffsetY.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = jumpDuration / 2, easing = EaseInCubic)
            )
        }

        delay(jumpDuration.toLong())

        launch {
            coinAlpha.animateTo(0f, animationSpec = tween(durationMillis = 300))
        }
        coinScale.animateTo(0f, animationSpec = tween(durationMillis = 300))


        launch {
            logoAlpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 250)
            )
        }
        logoRevealFraction.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 700,
                easing = EaseOutCubic
            )
        )

        delay(200L)
        onAnimationFinished()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF12323D))
    ) {
        if (coinAlpha.value > 0f) {
            Image(
                painter = painterResource(id = R.drawable.coin),
                contentDescription = "Moeda",
                modifier = Modifier
                    .size(coinSize)
                    .align(Alignment.Center)
                    .offset(x = coinOffsetX.value.dp, y = coinOffsetY.value.dp)
                    .scale(coinScale.value)
                    .alpha(coinAlpha.value),
                contentScale = ContentScale.Fit
            )
        }

        if (logoAlpha.value > 0f || logoRevealFraction.value > 0f) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "SaveMoneySlot logo",
                modifier = Modifier
                    .size(350.dp)
                    .align(Alignment.Center)
                    .alpha(logoAlpha.value)
                    .drawWithContent {
                        val revealedWidth = this.size.width * logoRevealFraction.value
                        val clipRectLeftCalculated = (this.size.width - revealedWidth) / 2f

                        clipRect(
                            left = clipRectLeftCalculated,
                            top = 0f,
                            right = clipRectLeftCalculated + revealedWidth,
                            bottom = this.size.height
                        ) {
                            this@drawWithContent.drawContent()
                        }
                    },
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IntroScreenPreview() {
    IntroScreen(onAnimationFinished = {})
}
