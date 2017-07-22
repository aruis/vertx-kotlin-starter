package com.aruistart.study.examples

class User3(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main(args: Array<String>) {
    val user = User3(mapOf(
            "name" to "John Doe",
            "age" to 25
    ))

    println(user.name)
    println(user.age)
}