package example.`val`.idx.observableMutable; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.val.idx.observableMutable.Events

object Events:

  def main(sa:  Array[String]): Unit =

    val buf = Idx.OM[Int]()

    buf.onChange(_.~.print)

    buf ++= (0 <>> 10)

    "Elements" +- buf.~ tp()

    buf.remove_<>(3 <> 5)

    "Elements" +- buf.~ tp()

