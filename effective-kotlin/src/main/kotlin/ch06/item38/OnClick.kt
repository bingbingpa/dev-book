package ch06.item38

class View

interface OnClick {
    fun clicked(view: View)
}

fun setOnClickListener(listener: OnClick) {

}

typealias OnClickType = (View) -> Unit
fun setOnClickListener2(onClick: OnClickType) {

}

class ClickListener : OnClick {
    override fun clicked(view: View) {
        TODO("Not yet implemented")
    }
}

class ClickListener2 : (View) -> Unit {
    override fun invoke(p1: View) {
        TODO("Not yet implemented")
    }
}



fun main() {
    setOnClickListener(object : OnClick {
        override fun clicked(view: View) {
            //
        }
    })

    setOnClickListener(ClickListener())

    setOnClickListener2(::println)
    setOnClickListener2(ClickListener2())

}