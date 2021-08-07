package example.performance.buffer; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.buffer.AddElementRaw

object AddElementRaw:

  def main(sa:  Array[String]): Unit =

    val CNT = 100000

    val array: Array[Time] = (0 <>> CNT).~.map(Time.current + _.Millis).toArray

    J.Benchmark.custom()(
      ("scala.Buffer[Time] ", () => { val b = scala.collection.mutable.Buffer.empty[Time]; for(i <- 0<>>CNT) b += array(i); b.size }),
      ("Time.Buffer        ", () => { val b: Time.Buffer = NEW;                            for(i <- 0<>>CNT) b += array(i); b.size }),
    )

