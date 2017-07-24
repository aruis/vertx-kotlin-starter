package com.aruistart.study.examples

fun main(args: Array<String>) {

    fun back() = println("ok")

    doSomething(1, ::back)
    doSomething2(2, ::back)

    fun back(x: Int) = println("ok" + x)

    doSomething3(1, ::back)
    doSomething4(2, ::back)
}


fun <R> doSomething(x: Int, back: Function0<out R>) {
    println(x)
    back()
}

fun <X> doSomething2(x: Int, back: () -> X) {
    println(x)
    back()
}


fun <A, R> doSomething3(x: A, back: Function1<A, R>) {
    println(x)
    back(x)
}

fun <A, X> doSomething4(x: A, back: (A) -> X) {
    println(x)
    back(x)
}
