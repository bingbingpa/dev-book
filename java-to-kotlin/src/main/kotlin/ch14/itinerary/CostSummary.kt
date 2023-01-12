package ch14.itinerary

import ch14.money.CurrencyConversion
import ch14.money.Money

data class CostSummary(
    val lines: List<CurrencyConversion>,
    val total: Money
)