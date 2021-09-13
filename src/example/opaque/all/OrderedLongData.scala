package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedLongData = OrderedLongData.TYPE.DEF

object OrderedLongData extends Long.Opaque.Data.Ordered[OrderedLongData]("OrderedLongData"):
  inline   def apply(inline v: Long)          : OrderedLongData = v.toOpaque                      // Base type constructor
  override def value_tag   (v:OrderedLongData): String          = v.toString + ".OrderedLongData" // Custom tag
  override def value_isVoid(v:OrderedLongData): Boolean         = v.real == 0                     // Optional void definition

  implicit inline def implicitFrom(v: \/)     : OrderedLongData = apply(0.toLong)                 // Optional void request

  extension (inline x: OrderedLongData)                                                           // Custom methods
    inline def next : OrderedLongData = (x.real + 1).toOpaque
    inline def prior: OrderedLongData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque

