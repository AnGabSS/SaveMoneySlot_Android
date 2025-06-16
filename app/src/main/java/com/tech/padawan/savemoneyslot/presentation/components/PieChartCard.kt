package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans
import ir.ehsannarmani.compose_charts.PieChart
import ir.ehsannarmani.compose_charts.models.Pie

@Composable
fun PieChartCard(chartData:  List<Pie>){
    var data by remember {
        mutableStateOf(
            chartData
        )
    }
    Row(
        modifier = Modifier.background(color = Color(0XFF14141C), shape = RoundedCornerShape(4.dp))
    ) {
        PieChart(
            modifier = Modifier.size(200.dp).padding(20.dp),
            data = data,
            onPieClick = {
                println("${it.label} Clicked")
                val pieIndex = data.indexOf(it)
                data = data.mapIndexed { mapIndex, pie -> pie.copy(selected = pieIndex == mapIndex) }
            },
            selectedScale = 1.1f,
            selectedPaddingDegree = 4f,
            scaleAnimEnterSpec = spring<Float>(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
            colorAnimEnterSpec = tween(300),
            colorAnimExitSpec = tween(300),
            scaleAnimExitSpec = tween(300),
            spaceDegreeAnimExitSpec = tween(300),
            style = Pie.Style.Stroke(width = 40.dp)
        )
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlowingDot()
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Fixed Expenses",
                    color = Color.White,
                    fontFamily = PixelifySans,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlowingDot(glowColor = Color(0XFFFF928A))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Restaurant",
                    color = Color.White,
                    fontFamily = PixelifySans,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlowingDot(glowColor = Color(0XFF3CC3DF))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Car maintenance",
                    color = Color.White,
                    fontFamily = PixelifySans,
                )
            }
        }
    }
}