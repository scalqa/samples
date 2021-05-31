
scalaVersion := "3.0.0"

fork in run  := true

scalaSource in Compile := baseDirectory.value / "src"

libraryDependencies += "org.scalqa" % "scalqa_3" % "0.92"