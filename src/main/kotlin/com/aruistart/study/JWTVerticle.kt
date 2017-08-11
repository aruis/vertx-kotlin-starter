package com.aruistart.study

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.jwt.JWTAuth
import io.vertx.ext.auth.jwt.JWTOptions
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.JWTAuthHandler
import io.vertx.ext.web.handler.StaticHandler
import scala.concurrent.Await.result


fun main(args: Array<String>) {
    Vertx.vertx().deployVerticle("com.aruistart.study.JWTVerticle");
}

class JWTVerticle : AbstractVerticle() {

    override fun start() {

        val router = Router.router(vertx)

        // Create a JWT Auth Provider
        val jwt = JWTAuth.create(vertx, JsonObject()
                .put("keyStore", JsonObject()
                        .put("type", "jceks")
                        .put("path", "keystore.jceks")
                        .put("password", "secret")))

        // protect the API
        router.route("/api/*").handler(JWTAuthHandler.create(jwt, "/api/newToken"))

        // this route is excluded from the auth handler
        router.get("/api/newToken").handler({ ctx ->
            ctx.response().putHeader("Content-Type", "text/plain")
            ctx.response().end(jwt.generateToken(JsonObject().put("name", "aruis"), JWTOptions().setExpiresInSeconds(10)))
        })

        // this is the secret API
        router.get("/api/protected").handler({ ctx ->
            ctx.response().putHeader("Content-Type", "text/plain")
            ctx.user()
            ctx.response().end("a secret you should keep for yourself...")


        })

        // Serve the non private static pages
        router.route().handler(StaticHandler.create())

        vertx.createHttpServer().requestHandler({ router.accept(it) }).listen(8080)
    }
}