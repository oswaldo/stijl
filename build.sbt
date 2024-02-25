val dottyVersion = "0.27.0-RC1"

enablePlugins(NativeImagePlugin)

lazy val root = project
  .in(file("."))
  .settings(
    name := "stijl",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.2",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.28",
  )
