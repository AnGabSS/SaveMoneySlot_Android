package com.tech.padawan.savemoneyslot.mocks


data class TransactionMock(
    val name: String,
    val type: Int,
    val value: Int
)


fun mockTreeTransactions(): List<TransactionMock> {
    return listOf(
        TransactionMock(name = "Game Pass", type = 1, value = 60),
        TransactionMock(name = "Salary", type = 2, value = 4000),
    )
}