package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedAnyRefData = OrderedAnyRefData.TYPE.DEF

object OrderedAnyRefData extends AnyRef.Opaque.Data.Ordered[OrderedAnyRefData,String]("OrderedAnyRefData"):
  inline   def apply(inline v: String)          : OrderedAnyRefData = v.toOpaque                          // Base type constructor
  override def value_tag   (v:OrderedAnyRefData): String            = v.toString + ".OrderedAnyRefData"   // Custom tag
  override def value_isVoid(v:OrderedAnyRefData): Boolean           = v.real.length ==  0                 // Optional void definition

  implicit inline def implicitFrom(v:VOID)       : OrderedAnyRefData = apply("")                           // Optional void request

  extension (inline x: OrderedAnyRefData)                                                                 // Custom methods
    inline def append(v: OrderedAnyRefData): OrderedAnyRefData = (x.real + v.real).toOpaque

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = AnyRef.Opaque

