package example.performance.stream; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.stream.MapOpt_vs_Collect

object MapOpt_vs_Collect:

  def main(sa: Array[String]): Unit =

    val CNT = 1001

    val a: Array[String] = (0 <>> CNT).stream.map(_.toString).toArray

    J.Benchmark(
      ("Array.collect",     () => {var i=0L; a         .collect{case v if v.length%2==0 => v                }.foreach(i += _.length); i}),
      ("Iterator.collect",  () => {var i=0L; a.iterator.collect{case v if v.length%2==0 => v                }.foreach(i += _.length); i}),
      ("Stream.mapOpt   ",  () => {var i=0L; a.stream  .mapOpt {case v if v.length%2==0 => v; case _ => VOID}.foreach(i += _.length); i}),
      ("Atream.MAP_OPT  ",  () => {var i=0L; a.stream  .MAP_OPT{case v if v.length%2==0 => v; case _ => VOID}.foreach(i += _.length); i}),
    )

