name := """playFrameworkExample"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

libraryDependencies ++= Seq(
"com.bot4s" %% "telegram-core" % "5.0.0",
"com.bot4s" %% "telegram-akka" % "5.0.0",
"org.typelevel" %% "cats-core" % "2.2.0"
)
libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.2.12",
  "com.typesafe.play" %% "play-slick" % "5.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0"
)



