package com.aruistart.study.action.reflection

fun foo(x: Int) = println(x)

/**
 * NOTE: This example uses reflection, which is not supported in the "Try Kotlin" online environment.
 * If you'd like to run it, please download the source code from https://www.manning.com/books/kotlin-in-action
 * and run it on your local machine.
 */
fun main(args: Array<String>) {
    val kFunction = ::foo
    kFunction.call(42)

    foo(42)
}

