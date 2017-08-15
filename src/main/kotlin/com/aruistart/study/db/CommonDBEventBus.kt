package com.aruistart.study.db

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.json.JsonObject
import io.vertx.ext.asyncsql.AsyncSQLClient
import io.vertx.ext.asyncsql.PostgreSQLClient
import kotlin.properties.Delegates

class CommonDBEventBus : AbstractVerticle() {

    private var dbClient: AsyncSQLClient by Delegates.notNull()


    override fun start(startFuture: Future<Void>?) {

        dbClient = PostgreSQLClient.createShared(vertx, JsonObject()
                .put("host", "127.0.0.1")
                .put("port", 5432)
                .put("maxPoolSize", 2)
                .put("username", "aruis")
                .put("password", "aruis")
                .put("database", "aruis"))



        vertx.eventBus().consumer<JsonObject>("common.db.query") { message ->


            println(Thread.currentThread().name+" get")

            var param = message.body()
            var table = param.getString("table")
            dbClient.getConnection { ar ->
                if (ar.succeeded()) {
                    val connection = ar.result()
                    connection.query("select * from $table limit 3") { res ->
                        connection.close()

                        println(Thread.currentThread().name)
                        message.reply(res.result().toJson().getJsonArray("rows"))

                    }
                }

            }

        }


        super.start(startFuture)
    }
}