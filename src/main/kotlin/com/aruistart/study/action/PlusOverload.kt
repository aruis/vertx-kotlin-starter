package com.aruistart.study.action


// times   *

operator fun Point.plus(other: Point): Point {
    println("extension plus")
    return Point(x + other.x, y + other.y)
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        println("overload plus")
        return Point(x + other.x, y + other.y)
    }
}


fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
}