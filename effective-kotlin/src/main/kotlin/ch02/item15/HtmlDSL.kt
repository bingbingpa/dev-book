package ch02.item15

@DslMarker
annotation class HtmlDSL

fun table(f: TableDsl.() -> Unit) {/**/ }

@HtmlDSL
class TableDsl {
    fun tr(f: TR.() -> Unit) {}
}

@HtmlDSL
class TR {
    fun td(f: TD.() -> Unit) {}
}

@HtmlDSL
class TD { /**/ }

fun main() {
    table {
        tr {
            td {}
            td {}
//            tr {} 컴파일 오류 발생
            this@table.tr {
                td {}
                td {}
            }
        }
    }
}