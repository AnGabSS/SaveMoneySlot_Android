package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tech.padawan.savemoneyslot.data.transaction.model.SearchedTransaction
import com.tech.padawan.savemoneyslot.getColorByTransactionType
import com.tech.padawan.savemoneyslot.parseDateToTime
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans
import java.text.NumberFormat
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

@Composable
fun TransactionListCard(transaction: SearchedTransaction) {
    val color = getColorByTransactionType(transaction.type)

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0x57FFFFFF), shape = RoundedCornerShape(4.dp))
            .padding(10.dp)
    ) {
        Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.CenterStart) {
            Text(
                text = transaction.name,
                color = Color.White,
                fontFamily = PixelifySans
            )
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            GlowingDot(glowColor = color)
        }

        Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
            TextWithBgColor(
                text = NumberFormat.getCurrencyInstance().format(transaction.value),
                modifier = Modifier.width(90.dp),
                bgColor = color
            )
        }

        Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.CenterStart) {
            Text(
                text = parseDateToTime(transaction.date),
                color = Color.White,
                fontFamily = PixelifySans
            )
        }
    }
}
