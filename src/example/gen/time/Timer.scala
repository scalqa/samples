package example.gen.time; import scalqa.{*,given}; import language.implicitConversions
/*
   Purpose: Illustrate power of Doc object documentation, where Doc can be printed as line, text, or table
*/

//SBT: runMain example.gen.time.Timer

object Timer:

  def main(sa: Array[String]): Unit =

    val start : Time        = Time.current
    val length: Time.Length = 2.Seconds + 111.Millis

    while(Time.current < start + length)
      // do something
        J.sleep(10.Millis)

    var totalLength: Time.Length = start.age

    println("Executed in: " + totalLength.tag)

