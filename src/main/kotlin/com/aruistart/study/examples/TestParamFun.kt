package com.aruistart.study.examples

fun main(args: Array<String>) {

    fun back() = println("ok")

    doSomething(1, ::back)
    doSomething2(2, ::back)
}


fun <R> doSomething(x: Int, back: Function0<out R>) {
    println(x)
    back()
}

fun <X> doSomething2(x: Int, back: () -> X) {
    println(x)
    back()
}
