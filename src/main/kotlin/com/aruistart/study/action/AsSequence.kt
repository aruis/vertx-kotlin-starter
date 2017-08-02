package com.aruistart.study.action

fun main(args: Array<String>) {
    println(listOf(1, 2, 3, 4).asSequence().iterator().next())

    val x =  listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it) "); it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .toList()

    println(x)

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}

