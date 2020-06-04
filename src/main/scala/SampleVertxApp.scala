import examples.{CounterExample, EventBusExample, ParentVerticleExample, PeriodicListenerExample}
import infrastructure.VertxComponents

object SampleVertxApp extends App
  with VertxComponents
  with ParentVerticleExample
  with PeriodicListenerExample
  with EventBusExample
  with CounterExample