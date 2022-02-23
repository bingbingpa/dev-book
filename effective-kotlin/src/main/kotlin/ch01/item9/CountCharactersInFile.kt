package ch01.item9

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun countCharactersInFile1(path: String): Int {
    val reader = BufferedReader(FileReader(path))
    reader.use {
        return reader.lineSequence().sumOf { it.length }
    }
}

fun countCharactersInFile2(path: String): Int {
    BufferedReader(FileReader(path)).use { reader ->
        return reader.lineSequence().sumOf { it.length }
    }
}

fun countCharactersInFile3(path: String): Int {
    File(path).useLines { lines ->
        return lines.sumOf { it.length }
    }
}

fun countCharactersInFile4(path: String): Int =
    File(path).useLines { lines ->
        lines.sumOf { it.length }
    }

fun main() {
    val path = System.getProperty("user.dir")
    println(countCharactersInFile1("$path/src/main/kotlin/ch01/item9/input.txt"))
    println(countCharactersInFile2("$path/src/main/kotlin/ch01/item9/input.txt"))
    println(countCharactersInFile3("$path/src/main/kotlin/ch01/item9/input.txt"))
    println(countCharactersInFile4("$path/src/main/kotlin/ch01/item9/input.txt"))
}