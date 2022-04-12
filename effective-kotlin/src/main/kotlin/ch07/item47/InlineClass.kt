package ch07.item47

@JvmInline
value class Minutes(private val minutes: Int) {
    fun toMillis(): Millis = Millis(minutes * 60 * 1000)
}

@JvmInline
value class Millis(val milliseconds: Int)

interface User {
    fun decidedAboutTime(): Minutes
    fun wakeUp()
}

interface Timer {
    fun callAfter(timeMillis: Millis, callback: () -> Unit)
}

fun setUpUserWakeUpUser(user: User, timer: Timer) {
    val time: Minutes = user.decidedAboutTime()
    timer.callAfter(time.toMillis()) {
        user.wakeUp()
    }
}
