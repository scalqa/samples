package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   ShortData = ShortData.TYPE.DEF

object ShortData extends Short.Opaque.Data[ShortData]("ShortData"):
  inline   def apply(inline v: Short)    : ShortData = v.toOpaque                    // Base type constructor
  override def value_tag   (v:ShortData) : String    = v.toString + ".ShortData"     // Custom tag
  override def value_isVoid(v:ShortData) : Boolean   = v.real == 0                   // Optional void definition

  implicit inline def implicitFrom(v: \/): ShortData = apply(0.toShort)              // Optional void request

  extension (inline x: ShortData)                                                    // Custom methods
    inline def next : ShortData = (x.real + 1).toShort.toOpaque
    inline def prior: ShortData = (x.real - 1).toShort.toOpaque

  object TYPE:
    opaque type DEF <: Short.Opaque = Short.Opaque

