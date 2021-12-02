package example.`val`.idx.observableMutable; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.val.idx.observableMutable.Events

object Events:

  def main(sa:  Array[String]): Unit =

    val buf = Idx.OM[Int]()

    buf.onChange(_.stream.print)

    buf ++= (0 <>> 10)

    "Elements" +- buf.stream tp()

    buf.removeRange(3 <> 5)

    "Elements" +- buf.stream tp()

