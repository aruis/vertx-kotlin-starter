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


        doAll().setHandler { ar ->
            if (ar.succeeded()) {
                println("All OK!")
            } else {
                print(ar.cause().message)
            }
        }

    }

    private fun doAll(): Future<String> {
        val fu1 = Future.future<String>()
        val fu2 = Future.future<String>()
        val fu3 = Future.future<String>()


        vertx.setTimer(1000, {
            println("do 1")
            fu1.complete()
        })


        return fu1.compose({
            println("do 2")
            fu2.complete()
        }, fu2)
                .compose({
                    println("do 3")
                    fu3.complete()
                }, fu3)


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