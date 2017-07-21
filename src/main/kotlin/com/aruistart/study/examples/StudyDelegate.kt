package com.aruistart.study.examples

import kotlin.reflect.KProperty


class Example() {
    var p: String by Delegate()
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}


fun main(args: Array<String>) {

    val e = Example()
    println(e.p)
    e.p = "NEW"
    println(e)
}