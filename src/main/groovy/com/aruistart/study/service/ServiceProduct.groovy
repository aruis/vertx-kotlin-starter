package com.aruistart.study.service

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.servicediscovery.Record
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.types.HttpEndpoint

class ServiceProduct extends AbstractVerticle {
    ServiceDiscovery discovery

    @Override
    void start(Future<Void> startFuture) throws Exception {


        discovery = ServiceDiscovery.create(vertx);


        Record record = HttpEndpoint.createRecord(
                "some-http-service", // The service name
                "localhost", // The host
                8080, // the port
                "/" // the root of the service
        );

        discovery.publish(record, { ar ->
            if (ar.succeeded()) {
                println("register")
                super.start(startFuture)
            }
            // ...
        })

//        discovery.close();


    }
}
