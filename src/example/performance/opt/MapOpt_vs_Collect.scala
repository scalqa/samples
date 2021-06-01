package example; package performance.opt; import language.implicitConversions

object MapOpt_vs_Collect:

  def main(sa: Array[String]): Unit =

    val CNT = 100000
    val a   : Array[String] = (0 <>> CNT).~.map(_.toString).toArray

    J.Benchmark(
      ("collect",  () => {var i=0L; for(j <- 0 <>> CNT) Some(a(j)).collect           {case v if v.length%2==0 => v              }.foreach(i += _.length); i}),
      ("map_?   ", () => {var i=0L; for(j <- 0 <>> CNT) a(j).?    .map_?[Opt[String]]{case v if v.length%2==0 => v; case _ => \/}.forval (i += _.length); i}),
    )
