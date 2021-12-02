package example.performance.stream; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.stream.RawReduce

object RawReduce:

  def main(arg: Array[String]): Unit =

    val COUNT = 10000

    val array : Array[Percent] = (1 <> COUNT).stream.map(_.Percent).toArray

    J.Benchmark(
      ("Iterator",     () => array.iterator.reduce(_ + _)),
      ("Array",        () => array         .reduce(_ + _)),
      ("Stream ",      () => array.stream  .reduce(_ + _)),
      ("Stream HEAVY", () => array.stream  .REDUCE(_ + _)),
    )
