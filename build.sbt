lazy val supportedScalaVersions: List[String] = List("2.11.12", "2.12.11", "2.13.2")

lazy val root = project
  .in(file("."))
  .settings(
      name := "numsc",
      organization:= "com.avasiu",
      githubOwner:= "alexvasiu",
      githubRepository:= "numsc",
      version := "0.0.2",
      licenses += "MIT" -> file("./LICENSE").toURI.toURL,
      description := "Numpy for Scala",
      crossScalaVersions := supportedScalaVersions,
      scalaVersion := supportedScalaVersions.last,
      libraryDependencies ++= Seq(
            "ch.qos.logback" % "logback-classic" % "1.2.3",
            "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
            "org.scalatest" %% "scalatest" % "3.1.2"
      )
  )
