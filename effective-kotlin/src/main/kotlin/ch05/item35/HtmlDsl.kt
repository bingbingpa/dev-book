package ch05.item35

fun table(init: TableBuilder.() -> Unit): TableBuilder {
    return TableBuilder().apply(init)
}

class TableBuilder {
    var trs = listOf<TrBuilder>()

    fun tr(init: TrBuilder.() -> Unit) {
        trs = trs + TrBuilder().apply(init)
    }
}

class TrBuilder {
    var tds = listOf<TdBuilder>()

    fun td(init: TdBuilder.() -> Unit) {
        tds = tds + TdBuilder().apply(init)
    }
}

class TdBuilder {
    var text = ""

    operator fun String.unaryPlus() {
        text += this
    }
}

fun main() {
    table {
        tr {
            for (i in 1..2) {
                td {
                    +"This is column $i"
                }
            }
        }
    }
}