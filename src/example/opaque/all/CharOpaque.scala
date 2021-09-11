package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   CharOpaque = CharOpaque.TYPE.DEF

object CharOpaque extends Char.Opaque.Base[CharOpaque]("CharOpaque"):
  inline   def apply(inline v: Char)     : CharOpaque = v.toOpaque                   // Base type constructor
  override def value_tag   (v:CharOpaque): String     = v.toString + ".CharOpaque"   // Custom tag

  extension (inline x: CharOpaque)                                                   // Custom methods
    inline def next : CharOpaque = (x.real + 1).toChar.toOpaque
    inline def prior: CharOpaque = (x.real - 1).toChar.toOpaque

  object TYPE:
    opaque type DEF <: Char.Opaque = Char.Opaque

