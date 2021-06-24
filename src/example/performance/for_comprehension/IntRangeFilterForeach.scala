package example.performance.for_comprehension; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.for_comprehension.IntRangeFilterForeach

object IntRangeFilterForeach:

  def main(sa:Array[String]): Unit =

    val CNT = 100000

    J.Benchmark(
      ("scala.Range", () => { var s=0L;  for(i <- 0 to CNT if i%2 == 0) s += i; s }),
      ("Int.<>     ", () => { var s=0L;  for(i <- 0 <> CNT if i%2 == 0) s += i; s }),
    )
