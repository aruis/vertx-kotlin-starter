package com.aruistart.study.examples

import java.util.*

class LazySample {
    var age: Int = 0

    val lazy: String by lazy {
        println("computed!")
        (age + 10).toString()
    }
}

fun main(args: Array<String>) {
    val sample = LazySample()
    println("lazy = ${sample.lazy}")
    sample.age = 20
    println("lazy = ${sample.lazy}")
}