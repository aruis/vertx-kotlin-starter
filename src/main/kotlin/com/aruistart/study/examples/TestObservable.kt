package com.aruistart.study.examples

import kotlin.properties.Delegates

class ObservableSample {
    var age: Int  by Delegates.observable(0) {
        d, old, new ->
        println(d.name)
        agex = new
    }

    var agex = 0
}

fun main(args: Array<String>) {
    val sample = ObservableSample()

    println("age is ${sample.age} , agex is ${sample.agex}")

    sample.age = 10

    println("age is ${sample.age} , agex is ${sample.agex}")

}