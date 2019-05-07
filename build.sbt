lazy val myproject = project.settings(
  scalaVersion := "2.12.6",
  addCompilerPlugin(scalafixSemanticdb),
  scalacOptions ++= List(
    "-Yrangepos",
    "-Ywarn-unused-import"
  ),
  Compile / compile := (Compile / compile).dependsOn((Compile / scalafix).toTask(" RemoveUnused")).value
)
