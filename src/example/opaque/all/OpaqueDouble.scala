package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueDouble = OpaqueDouble.TYPE.DEF

object OpaqueDouble extends Double.Opaque.Base[OpaqueDouble]("OpaqueDouble"):
  inline   def apply(inline v: Double)     : OpaqueDouble = v.toOpaque                    // Base type constructor
  override def value_tag   (v:OpaqueDouble): String       = v.toString + ".OpaqueDouble"  // Custom tag
  override def value_isVoid(v:OpaqueDouble): Boolean      = v.real == 0                   // Optional void definition

  implicit inline def implicitFrom(v: \/)  : OpaqueDouble = apply(0.toDouble)             // Optional void request

  extension (inline x: OpaqueDouble)                                                      // Custom methods
    inline def nextRound : OpaqueDouble = (x.real + 1).toLong.toDouble.toOpaque
    inline def priorRound: OpaqueDouble = (x.real - 1).toLong.toDouble.toOpaque

  object TYPE:
    opaque type DEF <: Double.Opaque = Double.Opaque

