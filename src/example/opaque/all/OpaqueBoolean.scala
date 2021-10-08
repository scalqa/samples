package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueBoolean = OpaqueBoolean.TYPE.DEF

object OpaqueBoolean extends Boolean.Opaque.Base[OpaqueBoolean]("OpaqueBoolean"):
  inline   def apply(inline v: Boolean)     : OpaqueBoolean = v.toOpaque                      // Base type constructor
  override def value_tag   (v:OpaqueBoolean): String        = v.toString + ".OpaqueBoolean"   // Custom tag

  extension (inline x: OpaqueBoolean)                                                         // Custom methods
    inline def reverse: OpaqueBoolean = (!x.real).toOpaque

  object TYPE:
    opaque type DEF <: Boolean.Opaque = Boolean.Opaque

