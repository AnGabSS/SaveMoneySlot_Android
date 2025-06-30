package com.tech.padawan.savemoneyslot.presentation.transaction

import android.media.Image
import android.view.SurfaceControl.Transaction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tech.padawan.savemoneyslot.R
import com.tech.padawan.savemoneyslot.data.transaction.model.SearchedTransaction
import com.tech.padawan.savemoneyslot.formatDate
import com.tech.padawan.savemoneyslot.getColorByTransactionType
import com.tech.padawan.savemoneyslot.mocks.mockTransactions
import com.tech.padawan.savemoneyslot.presentation.components.BackgroundForPreview
import com.tech.padawan.savemoneyslot.presentation.components.TextWithBgColor
import com.tech.padawan.savemoneyslot.presentation.components.TransactionListCard
import com.tech.padawan.savemoneyslot.ui.theme.PixelifySans
import java.time.LocalDate
import java.time.ZoneId

@Composable
fun Transactions(navController: NavHostController){

    val lastTransaction = mockTransactions(28)

    val lastTransactionsPerDate: Map<LocalDate, List<SearchedTransaction>> = lastTransaction.groupBy {
        it.date.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)

        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(color = Color(0x57FFFFFF), shape = RoundedCornerShape(8.dp)).padding(4.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Add icon",
                    modifier = Modifier.size(22.dp).padding(4.dp),

                )
                Text(
                    text = "Add",
                    color = Color.White,
                    fontFamily = PixelifySans,
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            lastTransactionsPerDate.forEach { transactionGroup ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                    Text(
                        text = formatDate(transactionGroup.key),
                        color = Color.White,
                        fontFamily = PixelifySans,
                    )
                    transactionGroup.value.forEach { transaction ->
                        TransactionListCard(transaction)
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun TransactionsPreview(){
    Transactions(rememberNavController())
}