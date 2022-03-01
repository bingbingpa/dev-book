package ch06.item36

open class Parent {
    fun a() {}
    open fun b() {}
}

class Child : Parent() {
//    override fun a() {} // 컴파일 오류
    override fun b() {}
}