package com.aruistart.study.service

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.ext.web.client.WebClient
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.ServiceReference

class ServiceCustomer extends AbstractVerticle {
    ServiceDiscovery discovery


    @Override
    void start(Future<Void> startFuture) throws Exception {

        discovery = ServiceDiscovery.create(vertx);

        discovery.getRecord({ r -> true }, { ar ->
            if (ar.succeeded()) {
                if (ar.result() != null) {

                    println("we have a record")

                    ServiceReference reference = discovery.getReference(ar.result());
                    // Retrieve the service object
                    WebClient client = reference.getAs(WebClient.class);

                    // You need to path the complete path
                    client.get("/").send { response ->

                        println response.result().body().toString()

                        // Dont' forget to release the service
                        reference.release();

                        // we have a record
                    }


                } else {
                    // lookup failed
                }
            }

            super.start(startFuture)
        })
    }
}