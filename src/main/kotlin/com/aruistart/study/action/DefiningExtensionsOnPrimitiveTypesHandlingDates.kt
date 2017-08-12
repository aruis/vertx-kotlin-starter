package com.aruistart.study.action

import java.time.LocalDate
import java.time.Period

val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

fun main(args: Array<String>) {
//    println(1.days)
    println(1.days.ago)
    println(1.days.fromNow)
}

