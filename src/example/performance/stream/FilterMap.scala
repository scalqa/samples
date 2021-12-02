package example.performance.stream; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.performance.stream.FilterMap

object FilterMap:

  def main(sa: Array[String]): Unit =

    case class Foo(id: Int, name: String)

    val CNT = 100000

    val array: Array[Foo] = (1 <> CNT).stream.map(i => Foo(i, "str"+i)).toArray

    J.Benchmark(
      ("Array",    () =>{var sum=0L; {for(f <- array          if f.id%2==0) yield f.name.length + f.id}.foreach(sum += _); sum}),
      ("Iterator", () =>{var sum=0L; {for(f <- array.iterator if f.id%2==0) yield f.name.length + f.id}.foreach(sum += _); sum}),
      ("Stream",   () =>{var sum=0L; {for(f <- array.stream   if f.id%2==0) yield f.name.length + f.id}.foreach(sum += _); sum}),
    )

