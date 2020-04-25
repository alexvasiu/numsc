lazy val root = project
  .in(file("."))
  .settings(
    name := "numsc",
    version := "1.0.0",

    scalaVersion := "0.23.0-RC1",
    scalacOptions ++= { if (isDotty.value) Seq("-language:Scala2Compat") else Nil },
    
    libraryDependencies ++= Seq(
        "com.novocode" % "junit-interface" % "0.11" % "test"
    ),
    libraryDependencies := libraryDependencies.value.map(_.withDottyCompat(scalaVersion.value))
  )
