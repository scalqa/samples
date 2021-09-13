package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedCharData = OrderedCharData.TYPE.DEF

object OrderedCharData extends Char.Opaque.Data.Ordered[OrderedCharData]("OrderedCharData"):
  inline   def apply(inline v: Char)          : OrderedCharData   = v.toOpaque                      // Base type constructor
  override def value_tag   (v:OrderedCharData): String            = v.toString + ".OrderedCharData" // Custom tag

  extension (inline x: OrderedCharData)                                                             // Custom methods
    inline def next : OrderedCharData = (x.real + 1).toChar.toOpaque
    inline def prior: OrderedCharData = (x.real - 1).toChar.toOpaque

  object TYPE:
    opaque type DEF <: Char.Opaque = Char.Opaque

