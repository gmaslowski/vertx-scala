package examples

import examples.CounterExample.{MAX_MILLIS, eventAddress}
import infrastructure.{Verticle, VertxComponents}
import io.vertx.scala.core.DeploymentOptions

trait CounterExample extends VertxComponents {

  vertx.deployVerticle("scala:examples.SomethingHappenedVerticle", DeploymentOptions().setInstances(7))
  vertx.deployVerticle(new CountingVerticle)

}

object CounterExample {
  val eventAddress = "somethingHappened"
  val MAX_MILLIS = 500
}

class SomethingHappenedVerticle extends Verticle {
  override def start(): Unit = {
    val r = scala.util.Random

    vertx.setPeriodic(r.nextInt(MAX_MILLIS), _ => {
      vertx.eventBus().publish(eventAddress, Option(""))
    })
  }
}

class CountingVerticle extends Verticle {

  var counter: Int = 0

  override def start(): Unit = {
    val eventConsumer = vertx.eventBus().consumer(eventAddress)

    eventConsumer.handler(message => {
      counter += 1
      logger.info(s"Counter: ${counter}")
    })
  }
}
