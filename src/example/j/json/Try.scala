package example.j.json

//SBT: runMain example.j.json.Try

object Try:

  def main(sa:  Array[String]): Unit =

    import scalqa.{*, given}

    J.Benchmark(
      ("Range ",()=>{ var sum=0L;
                      for(i <- 0 to 1000;
                          j <- 0 to 1000) sum += (i + j);
                      sum
                    }),
      ("Int.<>",()=>{ var sum=0L;
                      for(i <- 0 <> 1000;
                          j <- 0 <> 1000) sum += (i + j);
                       sum
                    }),
    )