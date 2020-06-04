package infrastructure

import io.vertx.scala.core.Vertx

trait VertxComponents {

  System.setProperty("vertx.logger-delegate-factory-class-name", "io.vertx.core.logging.SLF4JLogDelegateFactory")

  lazy val vertx = Vertx.vertx()

}
