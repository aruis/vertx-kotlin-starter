package com.aruistart.study.examples

fun main(args: Array<String>) {


    println(100.isFullScore())
    println(200.isFullScore())

    println(args.isEmpty)
}

fun Int.isFullScore(): Boolean = this == 100
val <T> Array<T>.isEmpty: Boolean get() = size == 0