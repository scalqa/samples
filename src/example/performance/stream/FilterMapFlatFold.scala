package example.performance.stream; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.stream.FilterMapFlatFold

object FilterMapFlatFold:

  def main(sa: Array[String]): Unit =

    val CNT = 100

    val ints  : Array[Int]         = (1 <> CNT).stream.toArray
    val array : Array[String]      = ints.stream.map(_.toString).toArray
    val sList : scala.List[String] = array.toList
    val vector: Vector[String]     = array.toVector

    J.Benchmark(
      ("Vector",       () => {for(s <- vector         if s.length%2==0; i <- ints       ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("scala.List",   () => {for(s <- sList          if s.length%2==0; i <- ints       ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Array",        () => {for(s <- array          if s.length%2==0; i <- ints       ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Iterator",     () => {for(s <- array.iterator if s.length%2==0; i <- ints       ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Stream",       () => {for(s <- array.stream   if s.length%2==0; i <- ints.stream) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Stream direct",() => array.stream.filter(_.length%2==0).flatMap (_ => ints.stream).map(_.toLong+1L).fold(0L)(_ + _)),
      ("Stream HEAVY", () => array.stream.FILTER(_.length%2==0).FLAT_MAP(_ => ints.stream).MAP(_.toLong+1L).FOLD(0L)(_ + _)),
    )

