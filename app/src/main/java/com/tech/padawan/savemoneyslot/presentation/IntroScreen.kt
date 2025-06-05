import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInCubic
import androidx.compose.animation.core.EaseInQuad
import androidx.compose.animation.core.EaseOutQuad
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun IntroScreen() {
    val newCoinSize = 50.dp

    val initialOffsetX = -200f
    val initialOffsetY = -400f

    val coinOffsetX = remember { Animatable(initialOffsetX) }
    val coinOffsetY = remember { Animatable(initialOffsetY) }
    val coinScale = remember { Animatable(1f) }
    val coinAlpha = remember { Animatable(0f) }

    val logoScale = remember { Animatable(0f) }
    val logoAlpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = Unit) {
        coinAlpha.animateTo(1f, animationSpec = tween(durationMillis = 200))
        launch {
            coinOffsetX.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 750, easing = LinearEasing)
            )
        }
        coinOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 750, easing = EaseInCubic)
        )

        coinScale.animateTo(0.8f, tween(70))
        coinScale.animateTo(1.2f, tween(70))

        coinOffsetY.animateTo(
            targetValue = -100f,
            animationSpec = tween(durationMillis = 350, easing = EaseOutQuad)
        )
        coinScale.animateTo(1f, tween(100))

        coinOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
        )


        launch {
            coinAlpha.animateTo(0f, animationSpec = tween(durationMillis = 300))
        }
        coinScale.animateTo(0f, animationSpec = tween(durationMillis = 300))

        launch {
            logoAlpha.animateTo(1f, animationSpec = tween(durationMillis = 300))
        }
        logoScale.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
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
                    .size(newCoinSize)
                    .align(Alignment.Center)
                    .offset(x = coinOffsetX.value.dp, y = coinOffsetY.value.dp)
                    .scale(coinScale.value)
                    .alpha(coinAlpha.value),
                contentScale = ContentScale.Fit
            )
        }

        if (logoAlpha.value > 0f) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "SaveMoneySlot logo",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.Center)
                    .scale(logoScale.value)
                    .alpha(logoAlpha.value),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IntroScreenPreview() {
    IntroScreen()
}