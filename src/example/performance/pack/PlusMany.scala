package example.performance.pack; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.pack.PlusMany

object PlusMany:

  def main(sa: Array[String]): Unit =
    "Started...".tp

    val CNT = 1000
    val array  : Array[Int]   = (1 <> CNT).~.toArray

    val list    : List[Int]   = array.toList
    val vector  : Vector[Int] = array.toVector
    val refPack : ><[Int]     = array.~.><
    val intPack : Int.><      = array.~.><

    J.Benchmark(
      ("List[Int]",   () => (list     ++ list     ++ (100 to 200) ++ array).size),
      ("Vector[Int]", () => (vector   ++ vector   ++ (100 to 200) ++ array).size),
      ("><[Int]",     () => (refPack  ++ refPack  ++ (100 <> 200) ++ array).size),
      ("Int.><",      () => (intPack  ++ intPack  ++ (100 <> 200) ++ array).size),
    )

