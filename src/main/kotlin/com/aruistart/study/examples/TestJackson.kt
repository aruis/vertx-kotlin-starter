package com.aruistart.study.examples

import com.aruistart.study.MainVerticle
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

val json = """{"wx": {"i": 224, "no": 4, "page": 12, "isSPU": 0, "state": 1}, "app": {"i": 298, "no": 8, "page": 30, "isSPU": 1, "state": "1"}, "web": {"i": 232, "no": 52, "page": 4, "isSPU": -1, "state": 1}}"""

data class Rank(val i: Int, val no: Int, val page: Int, val isSPU: Boolean, val state: String)
data class AllRank(val app: Rank, val wx: Rank, val web: Rank, val xx: Rank?)

fun main(args: Array<String>) {
    val mapper = jacksonObjectMapper()
    val state: MainVerticle.AllRank = mapper.readValue(json)

    println(json)
    println(state.app)
    println(state.app.state::class.java.name)
    println(state.app.isSPU)
    println(state.wx.isSPU)
    println(state.web.isSPU)
}