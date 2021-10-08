package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueString = OpaqueString.TYPE.DEF

object OpaqueString extends String.Opaque.Base[OpaqueString]("OpaqueString"):
  inline   def apply(inline v: String)     : OpaqueString = v.toOpaque                     // Base type constructor
  override def value_tag   (v:OpaqueString): String       = v.toString + ".OpaqueString"   // Custom tag

  extension (inline x: OpaqueString)                                                       // Custom methods
    inline def append(v: OpaqueString): OpaqueString = (x.real + v.real).toOpaque

  object TYPE:
    opaque type DEF <: String.Opaque = String.Opaque

