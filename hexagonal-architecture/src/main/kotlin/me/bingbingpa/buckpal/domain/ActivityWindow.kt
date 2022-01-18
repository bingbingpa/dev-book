package me.bingbingpa.buckpal.domain

import java.time.LocalDateTime
import java.util.*


class ActivityWindow {

    private var activities: MutableList<Activity>

    fun getStartTimestamp(): LocalDateTime {
        return activities.stream()
            .min(Comparator.comparing(Activity::timestamp))
            .orElseThrow { IllegalStateException() }
            .timestamp
    }

    fun endTimestamp(): LocalDateTime {
        return activities.stream()
            .max(Comparator.comparing(Activity::timestamp))
            .orElseThrow { IllegalStateException() }
            .timestamp
    }

    fun calculateBalance(accountId: AccountId?): Money {
        val depositBalance: Money = activities.stream()
            .filter { it.targetAccountId == accountId }
            .map { it.money }
            .reduce(Money.ZERO, Money::add)

        val withdrawalBalance: Money = activities.stream()
            .filter { it.sourceAccountId == accountId }
            .map { it.money }
            .reduce(Money.ZERO, Money::add)

        return Money.add(depositBalance, withdrawalBalance.negate())
    }

    constructor(activities: MutableList<Activity>) {
        this.activities = activities
    }

    constructor(vararg activities: Activity) {
        this.activities = ArrayList(listOf(*activities))
    }

    fun getActivities(): List<Activity> {
        return Collections.unmodifiableList(activities)
    }

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

}