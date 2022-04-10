package ch07

fun main() {
    println(sequenceOf(1, 2, 3).iterator().next())
    println(listOf(10, 20, 30).asSequence().iterator().next())
    println(
        mapOf(1 to "One", 2 to "Two").asSequence().iterator().next()
    )

    val numbers = generateSequence { readLine()?.toIntOrNull() }

    val powers = generateSequence(1) { it * 2}

    val evens = generateSequence(10) { if(it>=2) it -2 else null}

    val numbers2 = sequence {
        yield(0)
        yieldAll(listOf(1, 2, 3))
        yieldAll(intArrayOf(4, 5, 6).iterator())
        yieldAll(generateSequence(10) { if (it<50) it*3 else null})
    }

    println("numbers2 = $numbers2")

    println(intArrayOf(1,2,3,4,5).reduce{acc, n -> acc * n})
    println(listOf("a","b","c","d").reduce{acc, s -> acc + s})

    println(
        arrayOf("a","b","c","d").reduceRight { s, acc -> acc +s } // dcba
    )
}
