package com.aruistart.study.action

fun main(args: Array<String>) {
    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)
}