package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   OrderedByteData = OrderedByteData.TYPE.DEF

object OrderedByteData extends Byte.Opaque.Data.Ordered[OrderedByteData]("OrderedByteData"):
  inline   def apply(inline v: Byte)          : OrderedByteData = v.toOpaque                      // Base type constructor
  override def value_tag   (v:OrderedByteData): String          = v.toString + ".OrderedByteData" // Custom tag
  override def value_isVoid(v:OrderedByteData): Boolean         = v.real == 0                     // Optional void definition

  implicit inline def implicitFrom(v: \/)     : OrderedByteData = apply(0.toByte)                 // Optional void request

  extension (inline x: OrderedByteData)                                                           // Custom methods
    inline def next : OrderedByteData = (x.real + 1).toByte.toOpaque
    inline def prior: OrderedByteData = (x.real - 1).toByte.toOpaque

  object TYPE:
    opaque type DEF <: Byte.Opaque = Byte.Opaque

