package com.aruistart.study.web

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Vertx

class WebVerticle extends AbstractVerticle {

    static void main(String[] args) {
        Vertx.vertx().deployVerticle(WebVerticle.class.name)
    }


    @Override
    void start(Future<Void> startFuture) throws Exception {
        vertx.createHttpServer().requestHandler({ req ->
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!")
        }).listen(8080)
        super.start(startFuture)
    }
}
