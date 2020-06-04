package examples

import java.util.Date

import examples.EventBusExample.{MAX_MILLIS, eventAddress}
import infrastructure.{Verticle, VertxComponents}

trait EventBusExample extends VertxComponents {

  vertx.deployVerticle(new EventPublishingVerticle)
  vertx.deployVerticle(new EventHandlingVerticle)

}

object EventBusExample {
  val eventAddress = "someAddres"
  val MAX_MILLIS = 5000
}

class EventPublishingVerticle extends Verticle {
  override def start(): Unit = {
    val r = scala.util.Random

    vertx.setPeriodic(r.nextInt(MAX_MILLIS), _ => {
      val event = new Date().toString
      vertx.eventBus().publish(eventAddress, Option(event))
      logger.info(s"Sending a new event: ${event}")

    })
  }
}

class EventHandlingVerticle extends Verticle {
  override def start(): Unit = {
    val eventConsumer = vertx.eventBus().consumer(eventAddress)

    eventConsumer.handler(message => {
      logger.info(s"Received event: ${message.body}")
    })
  }
}
