package example.performance.pack; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.pack.FilterMapFlat

object FilterMapFlat:

  def main(sa: Array[String]): Unit =

    val CNT = 100

    val refPack : Pack[Int] = (1 <> CNT).stream.ref.pack
    val intPack : Int.Pack  = (1 <> CNT).stream.pack
    val list    : List[Int] = (1 to CNT).toList

    J.Benchmark(
      ("List[Int]", () => {val l: List[Int] =  for(i <- list    if i%2==0; j <- list    if i%5==0) yield i + j;       l.size}),
      ("Pack[Int]", () => {val l: Pack[Int] = {for(i <- refPack if i%2==0; j <- refPack if i%5==0) yield i + j}.pack; l.size}),
      ("Int.Pack",  () => {val l: Int.Pack  = {for(i <- intPack if i%2==0; j <- intPack if i%5==0) yield i + j}.pack; l.size}),
    )

