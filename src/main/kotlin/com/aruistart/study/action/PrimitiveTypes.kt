package com.aruistart.study.action

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

fun main(args: Array<String>) {
    showProgress(99)
    showProgress(129)
}

