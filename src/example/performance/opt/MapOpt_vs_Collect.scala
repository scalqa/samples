package example.performance.opt; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.opt.MapOpt_vs_Collect

object MapOpt_vs_Collect:

  def main(sa: Array[String]): Unit =

    val CNT = 100000
    val a   : Array[String] = (0 <>> CNT).stream.map(_.toString).toArray

    J.Benchmark(
      ("collect", () => {var i=0L; for(j <- 0 <>> CNT) Some(a(j)).collect{case v if v.length%2==0 => v                }.foreach(i += _.length); i}),
      ("mapOpt ", () => {var i=0L; for(j <- 0 <>> CNT) a(j).?    .mapOpt {case v if v.length%2==0 => v; case _ => VOID}.forval (i += _.length); i}),
    )

