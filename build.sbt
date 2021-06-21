
scalaVersion := "3.0.0"

fork in run  := true

scalaSource in Compile := baseDirectory.value / "src"

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

libraryDependencies ++= Seq("base", "controls", "fxml", "graphics", "media", "swing", "web").map( m=> "org.openjfx" % s"javafx-$m" % "11.0.2" classifier osName)

libraryDependencies += "org.scalqa" % "scalqa_3" % "0.93"

