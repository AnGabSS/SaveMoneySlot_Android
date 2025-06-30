package com.tech.padawan.savemoneyslot.data.transaction.model

import java.util.Date

data class SearchedTransaction(
    val name: String,
    val type: Int,
    val value: Double,
    val date: Date
)
