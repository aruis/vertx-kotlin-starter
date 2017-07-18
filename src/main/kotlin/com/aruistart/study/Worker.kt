package com.aruistart.study

import io.vertx.core.AbstractVerticle

/**
 * Created by chengen on 15/07/2017.
 */
class Worker : AbstractVerticle() {
    override fun start() {
        vertx.eventBus().consumer<String>(this.javaClass.name){ message ->
            vertx.setTimer(5000){
                message.reply("received!")
            }
        }
    }
}