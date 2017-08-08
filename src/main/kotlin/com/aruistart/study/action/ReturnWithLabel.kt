package com.aruistart.study.action

data class Person2(val name: String, val age: Int)

val people = listOf(Person2("Alice", 29), Person2("Bob", 31))

fun lookForAlice(people: List<Person2>) {
    people.forEach label@ {
        if (it.name == "Alice") return@label
    }
    println("Alice might be somewhere")
}

fun lookForAlice2(people: List<Person2>) {
    people.forEach {
        if (it.name == "Alice") return@forEach
        println(it.name)
    }
    println("Alice might be somewhere")
}

fun main(args: Array<String>) {
    lookForAlice(people)
    lookForAlice2(people)
}

