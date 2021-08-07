package example.performance.opt; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.opt.MapOpt_vs_Collect_Raw

object MapOpt_vs_Collect_Raw:

  def main(sa: Array[String]): Unit =

    val CNT               = 100000
    val a   : Array[Char] = (0 <>> CNT).~.map(_.toChar).toArray

    J.Benchmark(
      ("collect ", () => {var s=0L; for(j <- 0 <>> CNT)  Some(a(j)).collect       {case v if v%2==0 => v + 2              }.foreach(i => s += i.toLong); s}),
      ("map_?   ", () => {var s=0L; for(j <- 0 <>> CNT)  a(j).?    .map_?[Int.Opt]{case v if v%2==0 => v + 2; case _ => \/}.foreach(i => s += i.toLong); s}),
    )

