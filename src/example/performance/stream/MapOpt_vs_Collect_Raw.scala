package example.performance.stream; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.stream.MapOpt_vs_Collect_Raw

object MapOpt_vs_Collect_Raw:

  def main(sa: Array[String]): Unit =

    val CNT = 1000
    val a   : Array[Char]         = (0 <>> CNT).stream.map(_.toChar).toArray

    J.Benchmark(
      ("Array.collect   ",  () => {var i=0L; a         .collect{case v if v%2==0 => v + 2                }.foreach(i += _); i}),
      ("Iterator.collect",  () => {var i=0L; a.iterator.collect{case v if v%2==0 => v + 2                }.foreach(i += _); i}),
      ("Stream.mapOpt   ",  () => {var i=0L; a.stream  .mapOpt {case v if v%2==0 => v + 2; case _ => VOID}.foreach(i += _); i}),
      ("Stream.MAP_OPT  ",  () => {var i=0L; a.stream  .MAP_OPT{case v if v%2==0 => v + 2; case _ => VOID}.foreach(i += _); i}),
    )

