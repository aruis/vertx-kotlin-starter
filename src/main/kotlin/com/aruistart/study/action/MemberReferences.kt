package com.aruistart.study.action

fun salute() = println("Salute!")
data class Child(val name: String, val age: Int)


fun main(args: Array<String>) {
    run(::salute)

    val createPerson = ::Child
    val p = createPerson("Alice", 29)
    println(p)
}

