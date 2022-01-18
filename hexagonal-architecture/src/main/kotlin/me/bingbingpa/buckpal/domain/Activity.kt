package me.bingbingpa.buckpal.domain

import java.time.LocalDateTime

data class Activity(
    val ownerAccountId: AccountId?,
    val targetAccountId: AccountId?,
    val sourceAccountId: AccountId?,
    val timestamp: LocalDateTime,
    val money: Money
)

//data class ActivityId(private val value: Long)