package ch04

class Application private constructor(val name: String){
    companion object Factory {
        fun create(args: Array<String>): Application? {
            val name = args.firstOrNull() ?: return null
            return Application(name)
        }
    }
}

fun main() {
    val app = Application.create(arrayOf("Hello")) ?: return
    println("Application started: ${app.name}")
}