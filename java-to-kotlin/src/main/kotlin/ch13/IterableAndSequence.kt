package ch13

fun averageBlankLengthWithIterable(strings: List<String>): Double {
    return (strings
        .filter { it.isNotBlank() }
        .map(String::length)
        .sum() / strings.size.toDouble()
    )
}

fun averageNotBlankLengthWithSequence(strings: List<String>): Double {
    return (strings
        .asSequence()
        .filter(String::isNotBlank)
        .map(String::length)
        .sum() / strings.size.toDouble()
    )
}

fun averageNotBlankLengthWithSequenceAndSumBy(strings: List<String>): Double {
    return (strings
        .asSequence()
        .filter(String::isNotBlank)
        .sumOf(String::length)
            / strings.size.toDouble()
        )
}