import infrastructure.{Verticle, VerticleLogging}
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.core.DeploymentOptions;

trait ParentVerticleExample extends VertxComponents {
  vertx.deployVerticle(new ParentVerticle)
}


class ParentVerticle extends Verticle {

  override def start(): Unit = {
    logger.info("Starting couple of children")
    vertx.deployVerticle("scala:ChildVerticle", DeploymentOptions.apply().setInstances(5))
  }

  override def stop(): Unit = {
    logger.info("Stopping")
  }
}

class ChildVerticle extends ScalaVerticle
  with VerticleLogging {

  override def start(): Unit = {
    logger.info("Starting")
  }

  override def stop(): Unit = {
    logger.info("Stopping")
  }
}
