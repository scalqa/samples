package example.data; import scalqa.{*,given}; import language.implicitConversions

//SBT: runMain example.data.PriceData

object PriceData:

  extension (inline x: Double) inline def Dollars : Price = Price(x.Float)

  type  Price = Price.opaque.`type`

  object Price extends Float.Custom.Data.Number[Price]("Price"):
    inline   def apply(inline v: Float) : Price  = v.asOpaque[Price]
    override def tag(v:Price)           : String =  "$"+v.roundTo(0.01.Dollars).toString

    extension (x: Price)
      def discount(p: Percent): Price   = x - p(x)
      def isNotExpensive      : Boolean = x < 100F

    object opaque:
      opaque type `type` <: Any.Opaque.Float = Any.Opaque.Float

  def main(sa: Array[String]): Unit =

    J.Benchmark(
      ("Scala ",      () => (1 to 1000).iterator.map(v => (v % 200 + 0.99).Dollars).filter(_.isNotExpensive).map(_.discount(5.Percent)).sum),
      ("Scalqa",      () => (1 <> 1000).~       .map(v => (v % 200 + 0.99).Dollars).filter(_.isNotExpensive).map(_.discount(5.Percent)).sum),
      ("Scalqa Heavy",() => (1 <> 1000).~       .MAP(v => (v % 200 + 0.99).Dollars).FILTER(_.isNotExpensive).MAP(_.discount(5.Percent)).sum),
    )
