package com.tech.padawan.savemoneyslot.presentation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tech.padawan.savemoneyslot.getColorByTransactionType
import com.tech.padawan.savemoneyslot.mocks.TransactionMock
import com.tech.padawan.savemoneyslot.mocks.mockTreeTransactions
import com.tech.padawan.savemoneyslot.presentation.components.Header
import com.tech.padawan.savemoneyslot.presentation.components.PieChartCard
import com.tech.padawan.savemoneyslot.presentation.components.TextWithBgColor
import com.tech.padawan.savemoneyslot.presentation.components.TransactionListCard
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans
import ir.ehsannarmani.compose_charts.ColumnChart
import ir.ehsannarmani.compose_charts.models.BarProperties
import ir.ehsannarmani.compose_charts.models.Bars
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.Pie
import kotlin.random.Random

@Composable
fun Home(navController: NavHostController) {

    val lastTransaction: List<TransactionMock> = mockTreeTransactions()



    var data by remember {
        mutableStateOf(
            listOf(
                Pie(label = "Restaurant", data = 20.0, color = Color(0XFFFF928A), selectedColor = Color(0XFFFF3021)),
                Pie(label = "Fixed Expenses", data = 45.0, color = Color(0xFF8979FF), selectedColor = Color(0xFF553EFF)),
                Pie(label = "Car Maintenance", data = 35.0, color = Color(0XFF3CC3DF), selectedColor = Color(0XFF00A2C3)),
            )
        )
    }

    val linuxBrush = remember {
        Brush.verticalGradient(
            colors = listOf(Color(0xFFFFA500), Color.Yellow)
        )
    }
    val months = remember {
        listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    }
    val dynamicData = remember {
        months.map { monthName ->
            val randomValue = Random.nextDouble(from = -100.0, until = 100.0)

            Bars(
                label = monthName,
                values = listOf(
                    Bars.Data(
                        label = "Linux",
                        value = randomValue,
                        color = linuxBrush
                    )
                ),
            )
        }
    }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF12323D))
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp),
            modifier = Modifier
                .fillMaxSize().padding(top = 60.dp)
        ) {
            ColumnChart(
                modifier = Modifier.height(250.dp).fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                data = dynamicData,
                barProperties = BarProperties(
                    cornerRadius = Bars.Data.Radius.Rectangle(topRight = 6.dp, topLeft = 6.dp),
                    spacing = 3.dp,
                    thickness = 14.dp
                ),
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                ),
                indicatorProperties = HorizontalIndicatorProperties(
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = PixelifySans
                    ),
                    padding = 16.dp
                ),
                labelProperties = LabelProperties(
                    enabled = true,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = PixelifySans
                    )
                    ),
                labelHelperProperties = LabelHelperProperties(
                    enabled = true,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = PixelifySans
                    )
                ),
                minValue = -100.0,
                maxValue = 100.0

            )


            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ){
                TextWithBgColor(text = "Expenses per category")
                PieChartCard(data)

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier
                    .fillMaxWidth().padding(start = 20.dp, end = 20.dp)
            ) {
                TextWithBgColor(text = "Last Transactions", bgColor = Color.DarkGray)
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    lastTransaction.forEach { transaction ->
                        TransactionListCard(transaction.name, "R$ " + transaction.value, getColorByTransactionType(transaction.type))
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    Home(rememberNavController())
}