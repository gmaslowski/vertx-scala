import infrastructure.Verticle

trait SimpleVerticleExample extends VertxComponents {
  vertx.deployVerticle(new HelloWorldVerticle)
}

class HelloWorldVerticle extends Verticle {

  override def start(): Unit = {
    logger.info("Starting")
  }

  override def stop(): Unit = {
    logger.info("Stopping")
  }
}