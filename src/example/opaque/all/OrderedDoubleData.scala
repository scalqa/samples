package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedDoubleData = OrderedDoubleData.TYPE.DEF

object OrderedDoubleData extends Double.Opaque.Data.Ordered[OrderedDoubleData]("OrderedDoubleData"):
  inline   def apply(inline v: Double)          : OrderedDoubleData = v.toOpaque                        // Base type constructor
  override def value_tag   (v:OrderedDoubleData): String            = v.toString + ".OrderedDoubleData" // Custom tag
  override def value_isVoid(v:OrderedDoubleData): Boolean           = v.real == 0                       // Optional void definition

  implicit inline def implicitFrom(v: \/)       : OrderedDoubleData = apply(0.toDouble)                 // Optional void request

  extension (inline x: OrderedDoubleData)                                                               // Custom methods
    inline def nextRound : OrderedDoubleData = (x.real + 1).toLong.toDouble.toOpaque
    inline def priorRound: OrderedDoubleData = (x.real - 1).toLong.toDouble.toOpaque

  object TYPE:
    opaque type DEF <: Double.Opaque = Double.Opaque

