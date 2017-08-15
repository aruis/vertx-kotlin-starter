package com.aruistart.study.service

import io.vertx.core.Vertx

Vertx vertx = Vertx.vertx()

vertx.deployVerticle(ServiceProduct.newInstance(), { ar ->
    if (ar.succeeded()) {
        vertx.deployVerticle(ServiceCustomer.newInstance())
    } else {

    }

})