package example; package performance.buffer; import language.implicitConversions

import collection.mutable.ArrayBuffer

object AddElementRaw:

  def main(sa:  Array[String]): Unit =

    val CNT = 100000

    val array: Array[Time] = (0 <>> CNT).~.map(Time() + _.Millis).toArray

    J.Benchmark.custom()(
      ("scala.Buffer[Time] ", () => { val b = new ArrayBuffer[Time](); for(i <- 0<>>CNT) b += array(i); b.size }),
      ("Time.Buffer        ", () => { val b = new Time.Buffer();       for(i <- 0<>>CNT) b += array(i); b.size }),
    )
