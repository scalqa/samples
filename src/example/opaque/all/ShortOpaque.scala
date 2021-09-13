package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   ShortOpaque = ShortOpaque.TYPE.DEF

object ShortOpaque extends Short.Opaque.Base[ShortOpaque]("ShortOpaque"):
  inline   def apply(inline v: Short)     : ShortOpaque = v.toOpaque                   // Base type constructor
  override def value_tag   (v:ShortOpaque): String      = v.toString + ".ShortOpaque"  // Custom tag
  override def value_isVoid(v:ShortOpaque): Boolean     = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v: \/) : ShortOpaque = apply(0.toShort)             // Optional void request

  extension (inline x: ShortOpaque)                                                    // Custom methods
    inline def next : ShortOpaque = (x.real + 1).toShort.toOpaque
    inline def prior: ShortOpaque = (x.real - 1).toShort.toOpaque

  object TYPE:
    opaque type DEF <: Short.Opaque = Short.Opaque

