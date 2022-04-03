package ch06.item40

import java.net.URL

fun main() {
    val enWiki = URL("https://en.wikipedia.org/")
    val wiki = URL("https://wikipedia.org/")
    println(enWiki == wiki) // 인터넷이 되는 환경이면 ture, 아니라면 false
}