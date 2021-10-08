package example.opaque.all; import scalqa.{*,given}; import language.implicitConversions

type   OpaqueChar = OpaqueChar.TYPE.DEF

object OpaqueChar extends Char.Opaque.Base[OpaqueChar]("OpaqueChar"):
  inline   def apply(inline v: Char)     : OpaqueChar = v.toOpaque                   // Base type constructor
  override def value_tag   (v:OpaqueChar): String     = v.toString + ".OpaqueChar"   // Custom tag

  extension (inline x: OpaqueChar)                                                   // Custom methods
    inline def next : OpaqueChar = (x.real + 1).toChar.toOpaque
    inline def prior: OpaqueChar = (x.real - 1).toChar.toOpaque

  object TYPE:
    opaque type DEF <: Char.Opaque = Char.Opaque

