package com.aruistart.study.action

inline fun <reified T> isA(value: Any) = value is T

fun main(args: Array<String>) {
    println(isA<String>("abc"))
    println(isA<String>(123))
    println(isA<Number>(123))
    println(isA<Int>(123))
}

