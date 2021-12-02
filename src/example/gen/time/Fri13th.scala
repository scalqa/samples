package example.gen.time; import scalqa.{*,given}; import language.implicitConversions

// Count Fri the 13th in 20th century

//SBT: runMain example.gen.time.Fri13th

object Fri13th:

  def main(sa: Array[String]): Unit =

    J.Benchmark(
      ("Iterator",      () => (1901 to 2000).iterator.map(_.Year).flatMap(_.days.stream.iterator).filter(_.number == 13).count (_.weekDay.isFri)),
      ("Scalqa Stream", () => (1901 <> 2000).stream  .map(_.Year).flatMap(_.days.stream         ).filter(_.number == 13).filter(_.weekDay.isFri).count),
    )

