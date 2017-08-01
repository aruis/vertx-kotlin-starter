package com.aruistart.study.action


fun main(args: Array<String>) {

    data class Person(val name: String, val age: Int)

    val people = listOf(Person("Alice", 31),
            Person("Bob", 29), Person("Carol", 31))
    println(people.groupBy { it.age })

}

