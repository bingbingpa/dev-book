package ch01.item1

fun main() {
    val list = listOf(1, 2, 3)
    // 이렇게 하지 말자! 런타임에 UnsupportedOperationException 이 발생한다.
//    if (list is MutableList) {
//        list.add(4)
//    }
//    println(list)

    val mutableList = list.toMutableList()
    mutableList.add(4)
    println(mutableList)
}