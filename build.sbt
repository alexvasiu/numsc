lazy val root = project
  .in(file("."))
  .settings(
      name := "numsc",
      organization:= "com.avasiu",
      githubOwner:= "alexvasiu",
      githubRepository:= "numsc",
      version := "0.0.1",
      licenses += "MIT" -> file("./LICENSE").toURI.toURL,
      description := "Numpy for Scala",
      scalaVersion := "2.13.1",
      scalacOptions ++= Seq("-Xfatal-warnings"),
      libraryDependencies ++= Seq(
          "org.scalatest" %% "scalatest" % "3.1.1" % Test
      )
  )
