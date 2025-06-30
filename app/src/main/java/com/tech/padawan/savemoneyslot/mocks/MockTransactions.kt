package com.tech.padawan.savemoneyslot.mocks

import com.tech.padawan.savemoneyslot.data.transaction.model.SearchedTransaction
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import kotlin.math.round
import kotlin.random.Random

fun createRandomDate(startInclusive: LocalDate, endInclusive: LocalDate): Date {
    val startSeconds = startInclusive.atStartOfDay(ZoneId.systemDefault()).toEpochSecond()
    val endSeconds = endInclusive.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toEpochSecond()
    val randomSeconds = Random.nextLong(startSeconds, endSeconds)
    val randomInstant = java.time.Instant.ofEpochSecond(randomSeconds)
    return Date.from(randomInstant)
}

fun mockTransactions(itemsNumber: Int = 3): List<SearchedTransaction> {
    val today = LocalDate.now()
    val threeMonthsAgo = today.minusMonths(3)
    return buildList {
        for(i in 1..itemsNumber){
            add(
                SearchedTransaction(name = "Item test", type = (1..3).random(), value = round(Random.nextDouble(10.0, 500.0) * 100 ) / 100, date = createRandomDate(threeMonthsAgo, today)),
            )
        }
    }.sortedByDescending { it.date }
}