package ch10

import java.util.*

data class CustomerData(
    val id: String,
    val givenName: String,
    val familyName: String,
    val score: Int,
    val spend: Double
) {
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as CustomerData
        return score == that.score && java.lang.Double.compare(
            that.spend,
            spend
        ) == 0 && id == that.id && givenName == that.givenName && familyName == that.familyName
    }

    override fun hashCode(): Int {
        return Objects.hash(id, givenName, familyName, score, spend)
    }
}