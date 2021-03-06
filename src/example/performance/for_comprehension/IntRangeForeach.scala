package example.performance.for_comprehension; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.for_comprehension.IntRangeForeach

object IntRangeForeach:

  def main(sa:  Array[String]): Unit =

    val CNT = 100000

    J.Benchmark(
      ("scala.Range ", () => { var s=0L;  for(i <- 0 to CNT) s += i; s }),
      ("Int.Range   ", () => { var s=0L;  for(i <- 0 <> CNT) s += i; s }),
      ("coded loop  ", () => { var s=0L;  var i=0; while(i <= CNT){ s += i; i+=1}; s }),
    )
