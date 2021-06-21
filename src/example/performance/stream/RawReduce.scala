package example; package performance.stream; import language.implicitConversions

//SBT: runMain example.performance.stream.RawReduce

object RawReduce:

  def main(arg: Array[String]): Unit =

    val COUNT = 10000

    val array : Array[Percent] = (1 <> COUNT).~.map(_.Percent).toArray

    J.Benchmark(
      ("Iterator",() => array.iterator.reduce(_ + _)),
      ("Array",   () => array         .reduce(_ + _)),
      ("~ ",      () => array.~       .reduce(_ + _)),
      ("~ HEAVY", () => array.~       .REDUCE(_ + _)),
    )
