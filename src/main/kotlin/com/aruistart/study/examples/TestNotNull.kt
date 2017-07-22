package com.aruistart.study.examples

import kotlin.properties.Delegates

class User2 {
    var name: String by Delegates.notNull()

    fun init(name: String) {
        this.name = name
    }
}

fun main(args: Array<String>) {
    var user = User2()

//    user.name

    user.init("Carl")

    println(user.name)
}