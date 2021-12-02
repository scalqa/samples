package example.performance.buffer; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.buffer.AddElement

object AddElement:

  def main(sa:  Array[String]): Unit =

    val CNT = 100000

    val array: Array[String] = (0 <>> CNT).stream.map(_.toString).toArray

    J.Benchmark.custom()(
      ("scala.Buffer[String] ", () => { val b = scala.collection.mutable.Buffer.empty[String]; for(i <- 0 <>> CNT) b += array(i); b.size }),
      ("String.Buffer        ", () => { val b: String.Buffer = NEW;                            for(i <- 0 <>> CNT) b += array(i); b.size }),
    )
