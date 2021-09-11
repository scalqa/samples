package example.`opaque`.all; import scalqa.{*,given}; import language.implicitConversions

type   StringData = StringData.TYPE.DEF

object StringData extends String.Opaque.Data[StringData]("StringData"):
  inline   def apply(inline v: String)   : StringData = v.toOpaque                     // Base type constructor
  override def value_tag   (v:StringData): String     = v.toString + ".StringData"     // Custom tag

  extension (inline x: StringData)                                                     // Custom methods
    inline def append(v: StringData): StringData = (x.real + v.real).toOpaque

  object TYPE:
    opaque type DEF <: String.Opaque = String.Opaque

