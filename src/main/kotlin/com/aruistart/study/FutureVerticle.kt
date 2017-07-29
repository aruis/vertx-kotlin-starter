package com.aruistart.study

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Vertx

fun main(args: Array<String>) {
    Vertx.vertx().deployVerticle("com.aruistart.study.FutureVerticle")
}

class FutureVerticle : AbstractVerticle() {


    override fun start(startFuture: Future<Void>?) {

        doSomething1()
                .compose { doSomething2(it) }
                .compose { doSomething3() }
                .setHandler { ar ->
                    if (ar.succeeded()) {
                        println("All OK!")
                    } else {
                        print(ar.cause().message)
                    }
                }

        super.start(startFuture)
    }

    private fun doSomething1(): Future<String> {
        val future = Future.future<String>()

        vertx.setTimer(1000, {

            println("do first")
            future.complete("first ok")
        })

        return future
    }

    private fun doSomething2(str: String): Future<String> {
        val future = Future.future<String>()

        vertx.setTimer(1000, {
            println("do second,str is $str")
            future.complete("second ok")
//            future.fail("second error")
        })

        return future
    }

    private fun doSomething2err(): Future<String> {
        val future = Future.future<String>()

        vertx.setTimer(1000, {
            println("do second")
//            future.complete("second ok")
            future.fail("second error")
        })

        return future
    }

    private fun doSomething3(): Future<String> {
        val future = Future.future<String>()

        vertx.setTimer(1000, {
            println("do third")
            future.complete("third ok")
        })

        return future
    }
}