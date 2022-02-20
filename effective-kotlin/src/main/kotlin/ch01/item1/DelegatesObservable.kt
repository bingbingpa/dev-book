package ch01.item1

import kotlin.properties.Delegates

class DelegatesObservable {
    var names by Delegates.observable(listOf<String>()) { _, old, new ->
        println("names changed from $old to $new")
    }
}

fun main() {
    val name = DelegatesObservable()

    name.names += "Fabio"
    name.names += "Bill"
}