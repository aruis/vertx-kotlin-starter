package com.aruistart.study.database

import io.vertx.core.AbstractVerticle
import io.vertx.core.DeploymentOptions
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.asyncsql.AsyncSQLClient
import io.vertx.ext.asyncsql.PostgreSQLClient
import io.vertx.ext.sql.SQLConnection

class DatabaseVerticle extends AbstractVerticle {


    AsyncSQLClient client

    static void main(String[] args) {
        Vertx.vertx().deployVerticle(DatabaseVerticle.newInstance(), new DeploymentOptions().setInstances(1))
    }

    @Override
    void start(Future<Void> startFuture) throws Exception {

        client = PostgreSQLClient.createShared(vertx, new JsonObject([
                host       : "127.0.0.1",
                port       : 5432,
                maxPoolSize: 1,
                username   : "aruis",
                password   : "aruis",
                database   : "aruis"
        ]))


        client.getConnection({ ar ->
            if (ar.succeeded()) {
                SQLConnection conn = ar.result()

                conn.setAutoCommit(false, {
                    conn.query("select * from test where id =  1", { res ->

                        conn.updateWithParams("update test set v_name = ? where id = ? ", ["xxyy", 1], { res2 ->

                            println(res2.succeeded())

                            conn.commit({
                                conn.query("select * from test where id =  1", { res3 ->

                                    println(res3.result().rows)



                                    conn.rollback({

                                    })
                                })
                            })

//                            throw new Exception("xxx")

                        })

                        println(res.result().rows)
                    })
                })

//                conn.query("select * from test limit 3", { res ->
//                    conn.close()
//
//
//                    println(res.result().rows)
//                })


            }

        })



        super.start(startFuture)
    }


}
