/**
 * Created by chengen on 05/07/2017.
 */

import com.aruistart.study.Server
import com.aruistart.study.Worker
import io.vertx.core.AsyncResult
import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx
import io.vertx.core.eventbus.Message


fun main(args: Array<String>) {

    val vertx:Vertx = Vertx.vertx()

    vertx.deployVerticle(Server::class.java.name, DeploymentOptions().setInstances(5))
    vertx.deployVerticle(Worker::class.java.name, DeploymentOptions().setInstances(3))

    vertx.eventBus().send(Server::class.java.name,"hello"){ ar:AsyncResult<Message<String>> ->
        print(ar.result().body())
        vertx.close()
    }

}
