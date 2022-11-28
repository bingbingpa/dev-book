package ch4

import java.time.Duration

object Legs {
    fun List<Leg>.longestLegOver(duration: Duration): Leg? {
        val longestLeg = maxByOrNull(Leg::plannedDuration)
        return when {
            longestLeg == null -> null
            longestLeg.plannedDuration > duration -> longestLeg
            else -> null
        }
    }
}