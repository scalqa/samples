package example; package performance.stream; import language.implicitConversions

object FilterMap:

  def main(sa: Array[String]): Unit =

    val CNT = 10000

    val array: Array[String] = (1 <> CNT).~.map(_.toString).toArray

    J.Benchmark(
      ("Array",        () =>{var i=0L; {for(s <- array          if s.length%2==0) yield s.length * 123L}.foreach(i += _); i}),
      ("Iterator",     () =>{var i=0L; {for(s <- array.iterator if s.length%2==0) yield s.length * 123L}.foreach(i += _); i}),
      ("~",            () =>{var i=0L; {for(s <- array.~        if s.length%2==0) yield s.length * 123L}.foreach(i += _); i}),
    )
