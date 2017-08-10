package com.aruistart.study.action.reflection

class Person2(val name: String, val age: Int)

/**
 * NOTE: This example uses reflection, which is not supported in the "Try Kotlin" online environment.
 * If you'd like to run it, please download the source code from https://www.manning.com/books/kotlin-in-action
 * and run it on your local machine.
 */
fun main(args: Array<String>) {
    val person = Person2("Alice", 29)
    val memberProperty = Person2::age
    println(memberProperty.get(person))
}

