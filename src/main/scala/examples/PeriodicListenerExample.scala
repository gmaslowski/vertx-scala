package examples

import infrastructure.{VerticleLogging, VertxComponents}

trait PeriodicListenerExample extends VertxComponents
  with VerticleLogging {

  vertx.setPeriodic(1000, (id) => {
    logger.info(s"timer fired with id: ${id}")
  })

}
