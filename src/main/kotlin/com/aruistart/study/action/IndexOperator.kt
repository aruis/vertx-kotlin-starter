package com.aruistart.study.action


data class Pointx(val x: Int, val y: Int)

operator fun Pointx.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main(args: Array<String>) {
    val p = Pointx(10, 20)
    println(p[1])
}

