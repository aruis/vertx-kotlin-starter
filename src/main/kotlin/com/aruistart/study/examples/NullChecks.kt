package com.aruistart.study.examples

fun paresInt(str: String): Int? {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        println("argument isn't Int")
    }
    return null
}

fun getStringLength(obj: Any): Int? {
    if (obj is String)
        return obj.length
    return null
}

fun main(args: Array<String>) {

    println(getStringLength("aaa"))
    println(getStringLength(1))

    val x = paresInt("123")
    println(x)
    println(x is Number)

}