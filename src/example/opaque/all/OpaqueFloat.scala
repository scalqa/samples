package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueFloat = OpaqueFloat.TYPE.DEF

object OpaqueFloat extends Float.Opaque.Base[OpaqueFloat]("OpaqueFloat"):
  inline   def apply(inline v: Float)     : OpaqueFloat = v.toOpaque                   // Base type constructor
  override def value_tag   (v:OpaqueFloat): String      = v.toString + ".OpaqueFloat"  // Custom tag
  override def value_isVoid(v:OpaqueFloat): Boolean     = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v: \/) : OpaqueFloat = apply(0.toFloat)             // Optional void request

  extension (inline x: OpaqueFloat)                                                    // Custom methods
    inline def nextRound : OpaqueFloat = (x.real + 1).toLong.toFloat.toOpaque
    inline def priorRound: OpaqueFloat = (x.real - 1).toLong.toFloat.toOpaque

  object TYPE:
    opaque type DEF <: Float.Opaque = Float.Opaque

