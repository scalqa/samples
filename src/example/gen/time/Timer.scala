package example.gen.time; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.gen.time.Timer

object Timer:

  def main(sa: Array[String]): Unit =

    val start : Time        = Time.current
    val length: Time.Length = 2.Seconds + 111.Millis

    while(Time.current < start + length)
      // do something
        J.sleep(10.Millis)

    var totalLength: Time.Length = start.age

    println("Executed in: " + totalLength.tag)


/*
  // The resulting Java code does not have primitive boxing

  public void main(final String[] sa) {
      long start = System.currentTimeMillis();
      long length = 2000000000L + 111000000L;

      while(System.currentTimeMillis() < start + length / 1000000L) {
          scalqa.J.MODULE$.sleep(10000000L);
      }

      long totalLength = scalqa.gen.Time..MODULE$.age(start);
      scala.Predef..MODULE$.println("Executed  in: " + ZZ.tag(totalLength, scalqa.gen.time.Length..MODULE$.givenDocDef()));
  }
*/
