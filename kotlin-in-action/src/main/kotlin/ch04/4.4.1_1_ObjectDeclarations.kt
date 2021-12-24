package ch04

import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(p0: File, p1: File): Int {
        return p0.path.compareTo(p1.path, ignoreCase = true)
    }
}

fun main() {
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}