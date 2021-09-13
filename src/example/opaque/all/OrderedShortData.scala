package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedShortData = OrderedShortData.TYPE.DEF

object OrderedShortData extends Short.Opaque.Data.Ordered[OrderedShortData]("OrderedShortData"):
  inline   def apply(inline v: Short)          : OrderedShortData = v.toOpaque                       // Base type constructor
  override def value_tag   (v:OrderedShortData): String           = v.toString + ".OrderedShortData" // Custom tag
  override def value_isVoid(v:OrderedShortData): Boolean          = v.real == 0                      // Optional void definition

  implicit inline def implicitFrom(v: \/)      : OrderedShortData = apply(0.toShort)                 // Optional void request

  extension (inline x: OrderedShortData)                                                             // Custom methods
    inline def next : OrderedShortData = (x.real + 1).toShort.toOpaque
    inline def prior: OrderedShortData = (x.real - 1).toShort.toOpaque

  object TYPE:
    opaque type DEF <: Short.Opaque = Short.Opaque

