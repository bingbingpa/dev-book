package ch03

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I`m a view!")
fun Button.showOff() = println("I`m a Button!")

fun main() {
    val view: View = Button()
    view.click() //Button 클래스가 click 메소드를 오버라이드 했기 때문에 Button 의 메소드가 호출된다.
    view.showOff() //확장 함수는 오버라이드 할수 없다.(확장 함수는 정적으로 결정된다.)
}

