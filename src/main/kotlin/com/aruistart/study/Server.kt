package com.aruistart.study

/**
 * Created by chengen on 04/07/2017.
 */

import io.vertx.core.AbstractVerticle
import io.vertx.core.AsyncResult
import io.vertx.core.Context
import io.vertx.core.Vertx
import io.vertx.core.eventbus.EventBus
import io.vertx.core.eventbus.Message
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.suspendCoroutine

open class Server : AbstractVerticle() {
    override fun start() {
        val vertxContextDispatcher: VertxContextDispatcher = VertxContextDispatcher(vertx.orCreateContext, Thread.currentThread())

        vertx.eventBus().consumer<String>(this.javaClass.name) { message ->

            //Thread.sleep(5000) blocking delay for 5 seconds

            launch(vertxContextDispatcher) {



                // create new coroutine in current vertx thread
                delay(3000L) // non-blocking delay for 3 second (default time unit is ms)
                println(Thread.currentThread().toString() + "1") // print after delay
                val result1 = vertx.eventBus().send2(Worker::class.java.name, "message")
                println("here")
                println(Thread.currentThread().toString() + "2")
                val result2 = sendMessage(Worker::class.java.name, "message", vertx)
                println("there")
                println(Thread.currentThread().toString() + "3")
                println(result1.body().toString() + " " + result2.body().toString())
                println(Thread.currentThread().toString() + "4")
                message.reply("finished")
            }
        }
    }
}

//suspend fun sendMessage(): Message<Any> =
//        suspendCoroutine { cont ->
//            vertx.eventBus().send(address, message) { ar: AsyncResult<Message<Any>> ->
//                if (ar.succeeded()) cont.resume(ar.result())
//                else cont.resumeWithException(ar.cause())
//            }
//        }

suspend fun EventBus.send2(address: String, message: Any): Message<Any> = suspendCoroutine { cont ->
    this.send(address, message) { ar: AsyncResult<Message<Any>> ->
        if (ar.succeeded()) cont.resume(ar.result())
        else cont.resumeWithException(ar.cause())
    }
}

suspend fun sendMessage(address: String, message: Any, vertx: Vertx): Message<Any> =
        suspendCoroutine { cont ->
            vertx.eventBus().send(address, message) { ar: AsyncResult<Message<Any>> ->
                if (ar.succeeded()) cont.resume(ar.result())
                else cont.resumeWithException(ar.cause())
            }
        }

class VertxContextDispatcher(val vertxContext: Context, val vertxThread: Thread) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        if (Thread.currentThread() !== vertxThread) vertxContext.runOnContext { _ -> block.run() }
        else block.run()
    }
}