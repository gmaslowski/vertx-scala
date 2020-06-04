package infrastructure

import io.vertx.core.logging.LoggerFactory
import io.vertx.lang.scala.ScalaLogger

trait VerticleLogging {

  val logger = new ScalaLogger(LoggerFactory.getLogger(this.getClass.getName))

}
