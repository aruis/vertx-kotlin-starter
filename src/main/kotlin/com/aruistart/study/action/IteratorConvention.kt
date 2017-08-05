package com.aruistart.study.action

import java.util.Date
import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start

            override fun hasNext() =
                    current <= endInclusive

            override fun next() = current.apply {
                current = plusDays(1)
            }
        }

fun main(args: Array<String>) {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(10)..newYear
    for (dayOff in daysOff) { println(dayOff) }
}

