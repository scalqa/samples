package example.opaque; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.opaque.TemperatureData

object TemperatureData:
  // ----------------------------------------------------------------------------------------
  type  Fahrenheit = Fahrenheit.TYPE.DEF

  object Fahrenheit extends Double.Opaque.Data.Numerical[Fahrenheit]("Fahrenheit"):
    inline   def apply(inline v: Double): Fahrenheit = v.toOpaque
    override def value_tag(v:Fahrenheit): String     = v.toString + "F"

    extension (x: Fahrenheit)
      inline def toCelsius : Celsius    = Celsius((5D/9D) * (x.real - 32D))

    object TYPE:
      opaque type DEF <: Double.Opaque = Double.Opaque

  // ----------------------------------------------------------------------------------------
  type Celsius    = Celsius.TYPE.DEF

  object Celsius extends Double.Opaque.Data.Numerical[Celsius]("Celsius"):
    inline   def apply(inline v: Double): Celsius = v.toOpaque
    override def value_tag(v:Celsius)   : String  = v.toString + "C"

    extension(x: Celsius)
      inline def toFahrenheit : Fahrenheit = Fahrenheit(x.real * (9D/5D) + 32D)


    object TYPE:
      opaque type DEF <: Double.Opaque = Double.Opaque

  // ----------------------------------------------------------------------------------------
  def main(sa: Array[String]): Unit =
    "Started".tp

    val c : Celsius    = Celsius(27)
    val f : Fahrenheit = c.toFahrenheit

    c.tp
    f.tp

    val SIZE = 10000
    val fahrenheitArray: Array[Fahrenheit] = (1 to SIZE).map(v => Fahrenheit(50 + v % 40D)).toArray

    J.Benchmark(
      ("Scala",       () => (fahrenheitArray.iterator.map(_.toCelsius).filter(_ < Celsius(27)).sum / SIZE)),
      ("Scalqa",      () => (fahrenheitArray.~       .map(_.toCelsius).filter(_ < Celsius(27)).sum / SIZE)),
      ("Scalqa Heavy",() => (fahrenheitArray.~       .MAP(_.toCelsius).FILTER(_ < Celsius(27)).sum / SIZE)),
    )
