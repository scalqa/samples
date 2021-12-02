package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueShort = OpaqueShort.TYPE.DEF

object OpaqueShort extends Short.Opaque.Base[OpaqueShort]("OpaqueShort"):
  inline   def apply(inline v: Short)     : OpaqueShort = v.toOpaque                   // Base type constructor
  override def value_tag   (v:OpaqueShort): String      = v.toString + ".OpaqueShort"  // Custom tag
  override def value_isVoid(v:OpaqueShort): Boolean     = v.real == 0                  // Optional void definition

  implicit inline def implicitFrom(v:VOID) : OpaqueShort = apply(0.toShort)             // Optional void request

  extension (inline x: OpaqueShort)                                                    // Custom methods
    inline def next : OpaqueShort = (x.real + 1).toShort.toOpaque
    inline def prior: OpaqueShort = (x.real - 1).toShort.toOpaque

  object TYPE:
    opaque type DEF <: Short.Opaque = Short.Opaque

