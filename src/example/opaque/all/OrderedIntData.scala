package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedIntData = OrderedIntData.TYPE.DEF

object OrderedIntData extends Int.Opaque.Data.Ordered[OrderedIntData]("OrderedIntData"):
  inline   def apply(inline v: Int)          : OrderedIntData = v.toOpaque                     // Base type constructor
  override def value_tag   (v:OrderedIntData): String         = v.toString + ".OrderedIntData" // Custom tag
  override def value_isVoid(v:OrderedIntData): Boolean        = v.real == 0                    // Optional void definition

  implicit inline def implicitFrom(v:VOID)    : OrderedIntData = apply(0.toInt)                 // Optional void request

  extension (inline x: OrderedIntData)                                                         // Custom methods
    inline def next : OrderedIntData = (x.real + 1).toOpaque
    inline def prior: OrderedIntData = (x.real - 1).toOpaque

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

