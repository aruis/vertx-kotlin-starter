package com.aruistart.study.action

data class Client(val name: String, val postalCode: Int)

fun main(args: Array<String>) {
    val bob = Client("Bob", 973293)
    println(bob.copy(postalCode = 382555))
    println(bob.copy("Ada", 382555))
}

