package ch06.item37

data class Player(
    val id: Int,
    val name: String,
    val points: Int
)

fun main() {
    val player = Player(0, "Gecko", 9999)

    // toString
    println(player)

    // equals
    println(player == Player(0, "Gecko", 9999))
    println(player == Player(0, "Ross", 9999))

    // copy
    val newObj = player.copy(name = "Thor")
    println(newObj)

    // componentN
    val id: Int = player.component1()
    val name: String = player.component2()
    val pts = player.component3()

    println("id=$id, name=$name, points=$pts")

    val visited = listOf("korea", "germany", "france")
    val (first, second, third) = visited
    println("$first $second $third")

    val trip = mapOf(
        "China" to "Tiangin",
        "Russia" to "Petersburg",
        "India" to "Rishikesh"
    )
    for((country, city) in trip) {
        println("$city in $country")
    }


}