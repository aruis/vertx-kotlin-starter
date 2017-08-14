package com.aruistart.study.db

import io.vertx.core.AsyncResult
import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx
import io.vertx.core.eventbus.Message
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

fun main(args: Array<String>) {

    var vertx = Vertx.vertx()

    vertx.deployVerticle(CommonDBEventBus::class.java.name, DeploymentOptions().setInstances(1), {

        val eb = vertx.eventBus()

//        eb.send("com.aruistar", "hello")
        eb.send("common.db.query", JsonObject().put("table", "c_user")) { ar: AsyncResult<Message<JsonArray>> ->
            print(ar.result().body())
        }


    })


}