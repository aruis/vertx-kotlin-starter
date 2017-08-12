package com.aruistart.study.action

fun buildString(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString2(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

fun main(args: Array<String>) {
    var s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)

    s = buildString2 {
        this.append("Hello, ")
        append("World!")
    }
    println(s)
}

