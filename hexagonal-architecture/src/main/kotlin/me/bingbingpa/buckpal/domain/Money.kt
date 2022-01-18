package me.bingbingpa.buckpal.domain

import java.math.BigInteger

class Money(private val amount: BigInteger) {

    companion object {
        val ZERO: Money = of(0L)
        fun of(value: Long): Money {
            return Money(BigInteger.valueOf(value))
        }
        fun add(a: Money, b: Money): Money {
            return Money(a.amount.add(b.amount))
        }
        fun subtract(a: Money, b: Money): Money {
            return Money(a.amount.subtract(b.amount))
        }
    }

    fun isPositiveOrZero(): Boolean {
        return this.amount >= BigInteger.ZERO
    }

    fun isNegative(): Boolean {
        return this.amount < BigInteger.ZERO
    }

    fun isPositive(): Boolean {
        return this.amount > BigInteger.ZERO
    }

    fun isGreaterThanOrEqualTo(money: Money): Boolean {
        return this.amount >= money.amount
    }

    fun isGreaterThan(money: Money): Boolean {
        return this.amount.compareTo(money.amount) >= 1
    }

    fun minus(money: Money): Money {
        return Money(this.amount.subtract(money.amount))
    }

    fun plus(money: Money): Money {
        return Money(this.amount.add(money.amount))
    }

    fun negate(): Money {
        return Money(this.amount.negate())
    }
}

