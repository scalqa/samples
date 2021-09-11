package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedFloatData = OrderedFloatData.TYPE.DEF

object OrderedFloatData extends Float.Opaque.Data.Ordered[OrderedFloatData]("OrderedFloatData"):
  inline   def apply(inline v: Float)          : OrderedFloatData = v.toOpaque                       // Base type constructor
  override def value_tag   (v:OrderedFloatData): String           = v.toString + ".OrderedFloatData" // Custom tag
  override def value_isVoid(v:OrderedFloatData): Boolean          = v.real == 0                      // Optional void definition

  implicit inline def implicitFrom(v: \/)      : OrderedFloatData = apply(0.toFloat)                 // Optional void request

  extension (inline x: OrderedFloatData)                                                             // Custom methods
    inline def nextRound : OrderedFloatData = (x.real + 1).toLong.toFloat.toOpaque
    inline def priorRound: OrderedFloatData = (x.real - 1).toLong.toFloat.toOpaque

  object TYPE:
    opaque type DEF <: Float.Opaque = Float.Opaque

