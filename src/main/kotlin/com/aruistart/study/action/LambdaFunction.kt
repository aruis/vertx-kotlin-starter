package com.aruistart.study.action


var hello = { name: String ->

    println("Hello $name!")
}

fun main(args: Array<String>) {
    hello("Wrold")
}