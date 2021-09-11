package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   CharData = CharData.TYPE.DEF

object CharData extends Char.Opaque.Data[CharData]("CharData"):
  inline   def apply(inline v: Char)   : CharData   = v.toOpaque                   // Base type constructor
  override def value_tag   (v:CharData): String     = v.toString + ".CharData"     // Custom tag

  extension (inline x: CharData)                                                   // Custom methods
    inline def next : CharData = (x.real + 1).toChar.toOpaque
    inline def prior: CharData = (x.real - 1).toChar.toOpaque

  object TYPE:
    opaque type DEF <: Char.Opaque = Char.Opaque

