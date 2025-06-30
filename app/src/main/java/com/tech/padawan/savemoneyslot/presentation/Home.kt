package com.tech.padawan.savemoneyslot.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tech.padawan.savemoneyslot.R
import com.tech.padawan.savemoneyslot.data.transaction.model.SearchedTransaction
import com.tech.padawan.savemoneyslot.mocks.mockTransactions
import com.tech.padawan.savemoneyslot.presentation.components.PieChartCard
import com.tech.padawan.savemoneyslot.presentation.components.TextWithBgColor
import com.tech.padawan.savemoneyslot.presentation.components.TransactionListCard
import com.tech.padawan.savemoneyslot.presentation.navigation.Screen
import com.tech.padawan.savemoneyslot.ui.theme.BlueBg
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans
import ir.ehsannarmani.compose_charts.ColumnChart
import ir.ehsannarmani.compose_charts.RowChart
import ir.ehsannarmani.compose_charts.models.BarProperties
import ir.ehsannarmani.compose_charts.models.Bars
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.Pie
import ir.ehsannarmani.compose_charts.models.VerticalIndicatorProperties
import kotlin.random.Random

@Composable
fun Home(navController: NavHostController) {

    val lastTransaction: List<SearchedTransaction> = mockTransactions()
    var expandedDatePeriodSelector by remember { mutableStateOf(false) }
    var periodSelected by remember { mutableStateOf(12) }

    fun getPeriodLabel(months: Int): String {
        when(months){
            3 -> return "3 Months"
            6 -> return "6 Months"
            12 -> return "1 Year"
            else -> return "Invalid Period"
        }

    }



    var data by remember {
        mutableStateOf(
            listOf(
                Pie(label = "Restaurant", data = 20.0, color = Color(0XFFFF928A), selectedColor = Color(0XFFFF3021)),
                Pie(label = "Fixed Expenses", data = 45.0, color = Color(0xFF8979FF), selectedColor = Color(0xFF553EFF)),
                Pie(label = "Car Maintenance", data = 35.0, color = Color(0XFF3CC3DF), selectedColor = Color(0XFF00A2C3)),
            )
        )
    }

    val positiveColorBar = remember {
        Brush.horizontalGradient(
            colors = listOf(Color(0xFF004701), Color.Green)
        )
    }

    val negativeColorBar = remember {
        Brush.horizontalGradient(
            colors = listOf(Color(0xFF5E0000), Color.Red)
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
                        label = "Balance Per Month",
                        value = randomValue,
                        color = if(randomValue >= 0) positiveColorBar else negativeColorBar
                    )
                ),
            )
        }
    }



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp),
            modifier = Modifier
                .fillMaxSize().padding(top = 60.dp)
        ) {
            Box(contentAlignment = Alignment.TopCenter){
                Button(
                    onClick = { expandedDatePeriodSelector = !expandedDatePeriodSelector} ,
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(alpha = 0.5f)
                    )
                ) {
                    Text(
                        text = getPeriodLabel(periodSelected),
                        fontFamily = PixelifySans,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(R.drawable.baseline_arrow_drop_down_24),
                        contentDescription = "Coin image",
                        modifier = Modifier.size(20.dp)
                    )
                }
                DropdownMenu(
                    expanded = expandedDatePeriodSelector,
                    onDismissRequest = { expandedDatePeriodSelector = false },
                    modifier = Modifier.background(BlueBg).fillMaxWidth(),
                    offset = DpOffset(1.dp, 1.dp)
                ) {
                    DropdownMenuItem(
                        text = { Text("3 Month") },
                        onClick = {
                            periodSelected = 3
                            expandedDatePeriodSelector = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("6 Month") },
                        onClick = {
                            periodSelected = 6
                            expandedDatePeriodSelector = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("1 Year") },
                        onClick = {
                            periodSelected = 12
                            expandedDatePeriodSelector = false
                        }
                    )
                }
            }
            Box(
                modifier = Modifier
                .fillMaxWidth()
            ){
                RowChart(
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    data = dynamicData,
                    barProperties = BarProperties(
                        cornerRadius = Bars.Data.Radius.Rectangle(topRight = 6.dp, topLeft = 6.dp),
                        spacing = 4.dp,
                        thickness = 10.dp
                    ),
                    indicatorProperties = VerticalIndicatorProperties(
                        textStyle = TextStyle(
                            color = Color.White,
                            fontFamily = PixelifySans,
                            fontSize = 12.sp
                        ),
                        padding = 16.dp
                    ),
                    labelProperties = LabelProperties(
                        enabled = true,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontFamily = PixelifySans,
                            fontSize = 10.sp
                        ),
                        padding = 4.dp
                    ),
                    labelHelperProperties = LabelHelperProperties(
                        enabled = false,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontFamily = PixelifySans
                        )
                    ),
                    minValue = -100.0,
                    maxValue = 100.0
                )
            }


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
                        TransactionListCard(transaction)
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