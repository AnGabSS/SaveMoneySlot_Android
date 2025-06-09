package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.nativeCanvas

@Composable
fun GlowingDot(
    dotSize: Dp = 8.dp,
    glowColor: Color = Color(0xFF8979FF),
    glowRadius: Dp = 4.dp,
) {
    val glowRadiusPx = with(LocalDensity.current) { glowRadius.toPx() }

    Box(
        modifier = Modifier
            .size(dotSize)
            .drawBehind {
                drawIntoCanvas { canvas ->
                    val paint = Paint().asFrameworkPaint().apply {
                        isAntiAlias = true
                        color = glowColor.copy(alpha = 0.7f).toArgb()
                        maskFilter = android.graphics.BlurMaskFilter(
                            glowRadiusPx,
                            android.graphics.BlurMaskFilter.Blur.NORMAL
                        )
                    }

                    val center = Offset(size.width / 2, size.height / 2)
                    canvas.nativeCanvas.drawCircle(
                        center.x,
                        center.y,
                        size.width / 2,
                        paint
                    )
                }
            }
            .background(color = glowColor, shape = CircleShape)
    )
}

