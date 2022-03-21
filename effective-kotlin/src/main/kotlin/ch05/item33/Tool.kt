package ch05.item33

class Tool {
    companion object { /***/ }
}

class BigTool

fun Tool.Companion.createBigTool(): BigTool {
    return BigTool()
}

fun main() {
    Tool.createBigTool()
}