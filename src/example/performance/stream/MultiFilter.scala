package example.performance.stream; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.stream.MultiFilter

object MultiFilter:

  def main(sa: Array[String]): Unit =

    val CNT = 10000

    val array: Array[String] = (1 <> CNT).~.map(_.toString).toArray

    J.Benchmark(
      ("Array",   () =>{var i=0L; for(s <- array          if s.charAt(0)!='0' if s.charAt(0)!='2' if s.charAt(0)!='3' if s.charAt(0)!='4' if s.charAt(0)!='5')  i += s.length;  i}),
      ("Iterator",() =>{var i=0L; for(s <- array.iterator if s.charAt(0)!='0' if s.charAt(0)!='2' if s.charAt(0)!='3' if s.charAt(0)!='4' if s.charAt(0)!='5')  i += s.length;  i}),
      ("~",       () =>{var i=0L; for(s <- array.~        if s.charAt(0)!='0' if s.charAt(0)!='2' if s.charAt(0)!='3' if s.charAt(0)!='4' if s.charAt(0)!='5')  i += s.length;  i}),
      ("~ direct",() =>{var i=0L; array.~.filter(_.charAt(0)!='0').filter(_.charAt(0)!='2').filter(_.charAt(0)!='3').filter(_.charAt(0)!='4').filter(_.charAt(0)!='5').foreach(i += _.length); i}),
      ("~ HEAVY", () =>{var i=0L; array.~.FILTER(_.charAt(0)!='0').FILTER(_.charAt(0)!='2').FILTER(_.charAt(0)!='3').FILTER(_.charAt(0)!='4').FILTER(_.charAt(0)!='5').FOREACH(i += _.length); i}),
    )
