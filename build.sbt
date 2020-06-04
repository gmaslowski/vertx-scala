scalaVersion := "2.12.8"

name := "vertx-scala"
organization := "com.gmaslowski"
version := "1.0"

libraryDependencies += "io.vertx" %% "vertx-lang-scala" % "3.9.1"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.30"

fork in run := true
outputStrategy := Some(StdoutOutput)