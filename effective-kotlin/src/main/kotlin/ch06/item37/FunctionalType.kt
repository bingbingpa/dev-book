package ch06.item37

class View

interface OnClick {
    fun clicked(view: View)
}

fun setOnClickListener(listener: OnClick) {
    //...
}

fun main() {
    setOnClickListener(object : OnClick {
        override fun clicked(view: View) {
            //...
        }
    })
}